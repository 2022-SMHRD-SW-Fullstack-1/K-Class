package View;

import java.util.Scanner;

import Model.ASCII;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		ASCII.GameStart();

		while (true) {
			System.out.println("[1]회원가입 [2]로그인 [3]종료");
			int menu = scan.nextInt();

			if (menu == 1) { // 회원가입

			} else if (menu == 2) { // 로그인

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
