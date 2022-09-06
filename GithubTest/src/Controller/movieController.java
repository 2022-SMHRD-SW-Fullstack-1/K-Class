package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Model.MemberDAO;
import Model.MovieList;
import Model.MovieListDAO;
import javazoom.jl.player.MP3Player;

public class movieController {

	public static void mlist(int lv) {
		Scanner sc = new Scanner(System.in);
		MemberDAO Member = new MemberDAO();
		MovieListDAO Movie = new MovieListDAO();
		MP3Player mp3 = new MP3Player();

		ArrayList<MovieList> ml = Movie.movieList(lv);
		int score = 0;
		
		Collections.shuffle(ml);
		
		for (int i = 0; i < 5; i++) {
			System.out.println(ml.get(i).getName());
			System.out.println(ml.get(i).getLv());
			int rscore = 16;
			int cnt = 0;
			
			while(true) {
				System.out.println("[1]정답입력 [2]힌트보기");
				System.out.print("번호입력 >>>> ");
				int num = sc.nextInt();
				
				if (num == 1) {//답입력
					System.out.print("정답입력하세요 >>>> ");
					String ans = sc.next();
					
					if(ml.get(i).getName().equals(ans)) {
						if(cnt==3) {
							rscore=0;
						}
						score+=rscore;
						System.out.println("정답!");
						
						break;
					}
					else {
						System.out.println("오답! 땡!!");
						cnt++;
					}
				}else if (num == 2) {//힌트보기
					System.out.println(ml.get(i).getHint());
				}
				else {
					System.out.println("잘못입력 1 또는 2로 입력하기");
				}
				
			}
		}
//		int totalScore = Member.Scoreget(nick);
//		Member.updateScore(totalScore, nick);
		System.out.println(score+"점 입니다.");
	}
}
