package View;

import java.util.Scanner;

import Controller.GameController;
import Model.ASCII;

public class Main {

	private static final String String = null;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		ASCII.GameStart();
		GameController gc = new GameController();

		while (true) {

			gc.GameMenu();
			int menu = scan.nextInt();

			if (menu == 1) { // 회원가입
				gc.RegisterMenu();		

			} else if (menu == 2) { // 로그인
				gc.LoginMenu(id, pw);
				int sel = scan.nextInt();

			} else if (menu == 3) { // 종료
				System.out.println("퀴즈 종료");
				break;
			} else { // 오류
				System.out.println("다시 입력하세요");
			}
		}

		ASCII.GameEnd();

	}

}
