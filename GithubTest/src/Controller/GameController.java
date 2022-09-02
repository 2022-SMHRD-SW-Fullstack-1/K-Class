package Controller;

import java.util.Scanner;

public class GameController {

	Scanner scan = new Scanner(System.in);

	public static void GameMenu() { // 게임 시작 메뉴
		System.out.println("[1]회원가입 [2]로그인 [3]종료");
	}

	public static void RegisterMenu(String id, String pw) { // 회원 가입 메뉴
		System.out.print("아이디를 입력하세요");
		while (true) {
			if (id == id && pw == pw) { // 로그인 및 패스워드 정보가 맞다면

			} else { // 틀리다면

			}

		}

	}

	public static void LoginMenu() { // 로그인 메뉴

	}

}
