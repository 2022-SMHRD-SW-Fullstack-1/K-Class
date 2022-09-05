package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Model.Movie;
import javazoom.jl.player.MP3Player;

public class movieCon {
	
	Scanner sc = new Scanner (System.in);
	Movie movie = new Movie(null,null,null); //movie 초기화 객체생성
	ArrayList<Movie> movieList = new ArrayList<>();
	Random rd = new Random(); //문제 난이도 구분 랜덤수 생성기
	MP3Player mp3 = new MP3Player(); // 음원 재생, 정지 기능
	
	
	int[] indexList = new int[5];
	int index = 0; // movieList 목록 관리
	int score = 0; //점수관리
	int cnt = 0; //오답 카운팅
	int Ans = 0; //사용자 선택지 저장
	String movieAns = "";//사용자 영화 답안 저장
	
	
	
	
	
	public movieCon() {
		// 하
		movieList.add(new Movie("겨울왕국", "하/겨울왕국.mp3", "얼음마법을 쓰는 여왕"));
		movieList.add(new Movie("곡성", "하/곡성.mp3", "황정민, 곽도원"));
		movieList.add(new Movie("관상", "하/관상.mp3", "이정재, 송강호"));
		movieList.add(new Movie("라이언킹", "하/라이언킹.mp3", "사자가 주인공인 애니매이션"));
		movieList.add(new Movie("베테랑", "하/베테랑.mp3", "유아인, 황정민"));
		movieList.add(new Movie("보헤미안랩소디", "하/보헤미안랩소디.mp3", "영국 유명 밴드 퀸의 영화"));
		movieList.add(new Movie("써니", "하/써니.mp3", "어른이 되어 다신 만난 소녀들의 회상"));
		movieList.add(new Movie("아저씨", "하/아저씨.mp3", "금이빨 빼고 모조리 씹어먹어 줄게"));
		movieList.add(new Movie("알라딘", "하/알라딘.mp3", "3가지 소원을 말해봐"));
		movieList.add(new Movie("이웃집토토로", "하/이웃집토토로.mp3", "지브리의 가장 유명한 애니매이션"));
		movieList.add(new Movie("추격자", "하/추격자.mp3", "김윤석, 하정우"));
		movieList.add(new Movie("친구", "하/친구.mp3", "장동건의 학교영화"));
		movieList.add(new Movie("친절한금자씨", "하/친절한금자씨.mp3", "이영애, 최민식"));
		movieList.add(new Movie("캐리비안의해적", "하/캐리비안의해적.mp3", "조니뎁의 해적영화"));
		movieList.add(new Movie("타이타닉", "하/타이타닉.mp3", "디카프리오의 재난영화"));
		movieList.add(new Movie("하울의움직이는성", "하/하울의움직이는성.mp3", "마법으로 늙어버린 소녀와 마법사의 이야기"));

		// 중
		movieList.add(new Movie("건축학개론", "중/건축학개론.mp3", "수지, 이제훈"));
		movieList.add(new Movie("괴물", "중/괴물.mp3", "한강에 그것이 산다"));
		movieList.add(new Movie("내부자들", "중/내부자들.mp3", "모히또가서 몰디브 한잔"));
		movieList.add(new Movie("라라랜드", "중/라라랜드.mp3", "라이언 고슬링, 엠마 스톤"));
		movieList.add(new Movie("명량", "중/명량.mp3", "대한민국 역사상 가장 훌륭한 제독"));
		movieList.add(new Movie("박하사탕", "중/박하사탕.mp3", "입가심용 군것질"));
		movieList.add(new Movie("범죄와의전쟁", "중/범죄와의전쟁.mp3", "최민식, 하정우"));
		movieList.add(new Movie("비긴어게인", "중/비긴어게인.mp3", "아름다운 음악영화"));
		movieList.add(new Movie("신세계", "중/신세계.mp3", "드루와"));
		movieList.add(new Movie("엽기적인그녀", "중/엽기적인그녀.mp3", "전치현, 차태현"));
		movieList.add(new Movie("어벤져스", "중/어벤져스.mp3", "마블의 히어로물"));
		movieList.add(new Movie("올드보이", "중/올드보이.mp3", "군만두가 질릴것 같아"));
		movieList.add(new Movie("좋은놈나쁜놈이상한놈", "중/좋은놈나쁜놈이상한놈.mp3", "각자 목적인 있는 3인방"));
		movieList.add(new Movie("친절한금자씨", "중/친절한금자씨.mp3", "이영애, 최민식"));
		movieList.add(new Movie("타짜", "중/타짜.mp3", "내가 빙다리핫바지로 보이냐?"));
		movieList.add(new Movie("택시운전사", "중/택시운전사.mp3", "대한민국 민주화를 위해"));

		// 상
		movieList.add(new Movie("공공의적", "상/공공의적.mp3", "극악무도의 살인자를 잡자"));
		movieList.add(new Movie("내머리속의지우개", "상/내머리속의지우개.mp3", "시험 공부하면 가끔 이렇죠"));
		movieList.add(new Movie("달콤한인생", "상/달콤한인생.mp3", "이병헌, 김영철"));
		movieList.add(new Movie("도둑들", "상/도둑들.mp3", "김수현, 전지현"));
		movieList.add(new Movie("미션임파서블", "상/미션임파서블.mp3", "톰크루즈의 액션영화"));
		movieList.add(new Movie("베테랑", "상/베테랑.mp3", "한 분야의 전문가"));
		movieList.add(new Movie("부당거래", "상/부당거래.mp3", "황정민, 류승범"));
		movieList.add(new Movie("실미도", "상/실미도.mp3", "북파공작원들의 이야기"));
		movieList.add(new Movie("완벽한타인", "상/완벽한타인.mp3", "불편한 진실"));
		movieList.add(new Movie("웰컴투동막골", "상/웰컴투동막골.mp3", "한국전쟁 시대영화"));
		movieList.add(new Movie("인터스텔라", "상/인터스텔라.mp3", "SF영화의 한 획을 그은 영화"));
		movieList.add(new Movie("전우치", "상/전우치.mp3", "장난꾸러기인 도사"));
		movieList.add(new Movie("친구", "상/친구.mp3", "함께 있을 때, 우린 두려운게 없다!"));
		movieList.add(new Movie("클래식", "상/클래식.mp3", "손예진, 조인성"));
		movieList.add(new Movie("킬빌", "상/킬빌.mp3", "버림받은 여성의 복수영화"));
		movieList.add(new Movie("해바라기", "상/해바라기.mp3", "해를 좋아하는 꽃"));

	}

	
	//노래재생메소드
	public void play(int index) {
		// 노래 재생을 위한 메소드
		// 호출 시 musicList에 있는 노래를 play

		if (mp3.isPlaying()) { // 실행되는 노래가 있다면 멈추가 다시 재생
			mp3.stop();
		}
		mp3.play(movieList.get(index).getMoviePath());
	}
	
	
	//인덱스 랜덤 출력
	public void indexNum() {
		for(int i=0;i<indexList.length;i++) {
			//뽑을때부터 중복이 안되게
			indexList[i] =rd.nextInt(16)+1;
			
			//이전에 뽑은 랜덤 값 지금 뽑은 랜덤 값 일치하는지 확인하는 반복문
			for(int j=0;j<i;j++) {
				if(indexList[i]==indexList[j]) {
					//값이 같으면 다시 뽑게 ->i번째 숫자를 다시 뽑기
					i--;
					break;
					
				}
			}
			
		}
		System.out.println(Arrays.toString(indexList));
	}
	
	
	
	
	
	//난이도 하(0~15번 인덱스) 랜덤 출제
	public void lowQ() {
		indexNum();
		for(int i=1;i<=5;i++) {
		play(indexList[i]); //음원 재생
		System.out.println();//개행
		System.out.printf("[난이도 하] %d번째 문제!\n",i);
		System.out.println();//개행
		System.out.println("[1]정답입력 [2]힌트보기 >>\n(힌트 사용시 획득하는 점수가 줄어들어요)");
		Ans = sc.nextInt();
		System.out.println();//개행
		
			if(Ans==1) {//정답입력
				while(cnt<=3) {
					System.out.println();//개행
					System.out.print("정답입력 >> ");
					movieAns = sc.next();
					if(movieAns.equals(getName(indexList[i]))) {
						System.out.println("정답입니다!");
						break;
						//점수 추가
					}else {
						System.out.println("오답입니다! 다시 잘 들어보세요!");
						cnt++;
						play(indexList[i]); //음원 다시 재생
					}	
				}
				
				
				System.out.println();//개행
			}if(Ans==2) {//힌트보기
				System.out.println();//개행
				System.out.println("=====HINT=====");
				System.out.println(getHint(indexList[i]));
				break;
			}
			}
		

	}
	
	
	//난이도 중(16~31번 인덱스) 랜덤 출제

	
	
	//난이도 상(32~47번 인덱스) 랜덤 출제

	
	
	
	//힌트 불러오는 메소드
	public String getHint(int index) {
		String Hint = movieList.get(index).getHint();
		return Hint;
	}
	
	
	//영화 이름 불러오는 메소드
	public String getName(int index) {
		String Ans = movieList.get(index).getName();
		return Ans;
	}
	

}
