package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import Model.BgmMusic;
import Model.MovieListDAO;
import Model.MovieListDTO;
import javazoom.jl.player.MP3Player;
import Model.MemberDAO;
import Model.MemberDTO;

public class movieCon {

	Scanner sc = new Scanner(System.in);
	MovieListDAO mvDAO = new MovieListDAO();

	ArrayList<MovieListDTO> movieList = new ArrayList<>();
	Random rd = new Random(); // 문제 난이도 구분 랜덤수 생성기
	MP3Player mp3 = new MP3Player(); // 음원 재생, 정지 기능
	MemberDAO DAO = new MemberDAO();
	MemberDTO DTO = new MemberDTO();

	int[] indexList = new int[5];
	int index = 0; // movieList 목록 관리
	int score = 0; // 점수관리
	int rscore = 0;// 라운드별 점수
	int cnt = 0; // 오답 카운팅
	int Ans = 0; // 사용자 선택지 저장
	String movieAns = null;// 사용자 영화 답안 저장
	String userNick = null; // 현재 사용자 닉네임 저장
	ArrayList<BgmMusic> bgmList = new ArrayList<>();

	// 배경음악 저장
	public void bgmMusic() {
		bgmList.add(new BgmMusic("게임시작", "기타/게임시작.mp3"));

	}

	// 배경음악 재생
	public void playBgm(int index) {
		bgmMusic();
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(bgmList.get(index).getMusicPath());
	}

	// 로그인 후 닉네임 출력 메소드
	public String conLogin(String id, String pw) {

		userNick = DAO.login(id, pw);
		;
		return userNick;

	}
	
	
	
	// DB랜덤 재생목록 생성
	public void makeList(int lv) { // 레벨 입력 1-하 2-중 3-상
		movieList = mvDAO.movieList(lv); // 난이도별 노래 목록 생성 명령어
		Collections.shuffle(movieList); // ml무작위로 섞는 명령어
	}

	// DB연동 노래재생메소드
	public void playDB(int index) { // 0부터 4까지만 상승되도록

		if (mp3.isPlaying()) { // 실행되는 노래가 있다면 멈추가 다시 재생
			mp3.stop();
		}
		mp3.play(movieList.get(index).getmoviepath()); // 노래 재생
	}

	// 문제 출제 level -난이도("하","중","상" / lv 1-하 2-중 3-상 / maxscore 16-하 18-중 20-상)
	public void makeQuiz(String level, int lv, int maxscore) {
		if (DAO.Scoreget(userNick) == 0) {// 기존 점수가 없는 유저
			score = 0;
		} else { // 기존 점수가 있는 유저
			score = DAO.Scoreget(userNick);
		}
		makeList(lv);

		for (int i = 1; i <= 5; i++) {
			playDB(i); // 인덱스 0부터 4까지 상승
			System.out.println(); // 개행
			System.out.printf("	     [난이도 %s] %d번째 문제!\n", level, i);
			System.out.println("	잘 듣고 생각나는 영화를 입력하세요!");
			System.out.println();// 개행
			cnt = 0;
			rscore = maxscore;
			System.out.print("	[1]정답입력 [2]힌트보기 >> ");
			Ans = sc.nextInt();
			if (Ans == 1) {
				makeQ(i + index);
			} else {
				hint(i + index);
			}
		}
		if (DAO.Scoreget(userNick) == 0) {
			DAO.insertScore(userNick, score);
		} else {
			// 업데이트
			DAO.updateScore(score, userNick);
		}

		System.out.println("===================게임종료==================");
		if (mp3.isPlaying()) { // 실행되는 노래가 있다면 멈추가 다시 재생
			mp3.stop();
		}
		System.out.printf("    %s 님의 총 점수 : %d \n", userNick, DAO.Scoreget(userNick));
		System.out.println("===========================================");
		System.out.println(); // 개행

	}

	// 답 비교하는 메소드
	public boolean check(int index) { // 인덱스 0부터 4까지 상승
		return movieAns.equals(movieList.get(index).getName());
	}

	// 힌트 불러오는 메소드
	public String getHint(int index) { // 인덱스 0부터 4까지 상승
		String Hint = movieList.get(index).getHint();
		return Hint;
	}

	// 영화 이름 불러오는 메소드
	public String getName(int index) { // 인덱스 0부터 4까지 상승
		String Ans = movieList.get(index).getName();
		return Ans;
	}

	// 문제입력 및 결과출력 메소드
	public void makeQ(int i) {
		while (cnt < 3) {
			System.out.println();// 개행
			System.out.print("	정답입력 >> ");
			movieAns = sc.next();
			cnt++;

			if (check(i)) {// 정답의 경우 인덱스 0부터 4까지 상승
				System.out.println("	정답입니다!");
				score += rscore; // 스코어 상승
				System.out.println(score + " / " + rscore);
				break; // 힌트없이 한번에 정답 맞춤 반복문 나가기
			} else {// 오답의 경우
				playDB(i);// 인덱스 0부터 4까지 상승
				System.out.println();// 개행
				System.out.println("	오답입니다. 다시 들어보세요.");
				System.out.println();
				rscore -= 3;
				if (cnt < 2 && Ans == 1) {
					System.out.println("====================HINT===================");
					System.out.println("	   " + movieList.get(i).getHint());
					System.out.println("===========================================");
				}
				if (cnt == 3) {
					System.out.println();
					System.out.println("	기회를 소진하여 다음 문제로 넘어갑니다!");
					System.out.println("	이번 문제의 정답은 [" + movieList.get(i).getName() + "]");
					System.out.println("===========================================");
					rscore = 0;
				}
			}
		}
	}

	// 힌트 골랐을 경우 메소드
	public void hint(int i) { // 인덱스 0부터 4까지 상승
		playDB(i);
		System.out.println("====================HINT===================");
		System.out.println("	   " + movieList.get(i).getHint());
		System.out.println("===========================================");
		rscore -= 2;
		makeQ(i);
	}

}
