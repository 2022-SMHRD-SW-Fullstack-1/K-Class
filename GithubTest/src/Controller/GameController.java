package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.MemberDAO;
import Model.MemberDTO;

public class GameController {

	MemberDAO dao = new MemberDAO();

	int cnt = 0;

	public int conInsert(String id, String pw, String nick, int age) {
		// view가 넘겨준 회원가입에 대한 정보를 DAO로 연결해 주는 메소드
		cnt = dao.insert(id, pw, nick, age);

		return cnt;
	}

	public ArrayList<MemberDTO> conSelect() {

		ArrayList<MemberDTO> totalList = new ArrayList<>();

		totalList = dao.select();

		return totalList;
	}

	// 로그인을 진행하기 위한 Controller 요청
	public String conLogin(String id, String pw) {

		String nick = dao.login(id, pw);

		return nick;
	}

}