package View;

import java.util.Scanner;

import Controller.movieCon;
import Model.ASCII;
import Model.UserInfo;

public class View {

	public static void main(String[] args) {

		movieCon mc = new movieCon(); // 컨트롤러 연결
		Scanner sc = new Scanner(System.in);
		ASCII ascii = new ASCII();
		UserInfo userDAO = new UserInfo();

		int result = 0; // sql성공여부확인 변수

		// ascii.GameStart();
		// 게임시작 아스키코드 출력 일단 주석처리

		// 게임 첫 실행시 메인 화면 아스키코드 불러오기(메소드 사용)

		while (true) {
			System.out.println();// 개행
			System.out.print("[1]회원가입 [2]로그인 [3]랭킹확인 [4]종료 >> "); // 초기 메인메뉴창
			int menu = sc.nextInt(); // 사용자 메뉴선택

			if (menu == 1) {// 회원가입
				System.out.println();// 개행
				System.out.println("=====회원가입=====");

				System.out.print("사용할 아이디를 입력하세요 >> ");
				String userId = sc.next();

				System.out.print("사용할 비밀번호를 입력하세요 >> ");
				String userPw = sc.next();

				System.out.print("사용할 닉네임을 입력하세요 >> ");
				String userNick = sc.next();

				boolean check = userDAO.userInsert(userId, userPw, userNick);

				if (check) {
					System.out.println("가입 성공!");
				} else {
					System.out.println("가입 실패...");
				}

			} else if (menu == 2) {// 로그인
				System.out.println();// 개행
				System.out.println("=====로그인=====");

				System.out.print("아이디를 입력하세요 >> ");
				String userId = sc.next();

				System.out.print("비밀번호를 입력하세요 >> ");
				String userPw = sc.next();
				
				boolean check = userDAO.login(userId, userPw);
				
				if (check) { // 로그인 성공시
					System.out.println(userId+"님 접속을 환영합니다!"); // 닉네임 동시 출력
					System.out.print("난이도를 선택하세요 [1]하 [2]중 [3]상 >> ");
					int gameMenu = sc.nextInt();// 사용자 난이도 선택

					if (gameMenu == 1) {// 게임 난이도 하
						mc.lowQ();
					} else if (gameMenu == 2) {// 게임 난이도 중
						mc.midQ();
					} else if (gameMenu == 3) {// 게임 난이도 상
						mc.highQ();
					} else {
						System.out.println("번호를 다시 입력하세요");
					}

				} else { // 로그인 실패시
					System.out.println("로그인 정보를 다시 확인하세요");

				}

			} else if (menu == 3) {// 랭킹확인
				System.out.println();// 개행
				System.out.println("=====랭킹확인=====");
				// 랭킹출력 점수 높은 순으로 출력(점수 값 같을시 데이터 빠른 순)
				userDAO.rank();

			} else if (menu == 4) {// 종료
				System.out.println();// 개행
				// ascii.GameEnd();
				// 종료 아스키코드 출력(주석처리)
				sc.close();
				break;
			} else {
				System.out.println();// 개행
				System.out.println("번호를 다시 입력하세요");
			}

		}

	}

	private static void login(String userId, String userPw) {
		// TODO Auto-generated method stub
		
	}

}
