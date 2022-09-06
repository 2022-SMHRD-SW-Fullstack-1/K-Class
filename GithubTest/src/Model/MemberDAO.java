package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	boolean check = false;
	int score = 0;
	


	public void connect() { //DB연결 메소드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_k_0830_1";
			String db_pw = "smhrd1";

			conn = DriverManager.getConnection(url, db_id, db_pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() { //DB닫는 메소드
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {// Exception
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//회원가입 DB 연결
	public boolean userInsert(String id, String pw, String nick) { 
		try {
			connect();
			
		
			String sql = "insert into member values(?, ?, ?)";// 저장될 테이블 이름수정하기

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);

			int result = psmt.executeUpdate();

			if (result > 0) {
				check = true;
			} else {
				check = false;
			}
		} catch (Exception e) {
			System.out.println("중복된 아이디이거나 잘못된 형식입니다.");
		} finally {
			close();
		}
		return check;
	}

	//로그인정보 DB확인
	public String login(String id, String pw) {
		String userNick = null;

		try {
			connect();

			String sql = "select nick from member where id=? and pw=?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,id);
			psmt.setString(2,pw);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				userNick = rs.getString(1);
			}
			
		} catch (Exception e) {
		} finally {
			close();
		}
		return userNick;
	}
	
	//로그인정보 스코어 가져오기
		public int Scoreget(String nick) {
			int score = 0;

			try {
				connect();

				String sql = "select score from ranking where nick=?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1,nick);
				
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					score = rs.getInt("score");
				}
				
			} catch (Exception e) {
			} finally {
				close();
			}
			return score;
		}
	

	//랭킹 DB에 저장
	public ArrayList<MemberDTO> rank() {
		int n = 1;
		ArrayList<MemberDTO> al = new ArrayList<MemberDTO>();
		try {
			connect();

			String sql = "select * from ranking order by score desc";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			System.out.println("  닉네임\t점수");
			while (rs.next()) {
				String nick = rs.getString("nick");
				int score = rs.getInt("score");
				System.out.println(n+". "+nick + "\t" + score);
				n++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}
	
	
	//첫 점수 생성
	public boolean insertScore(String nick, int score) {
		try {
			connect();
			
		
			String sql = "insert into ranking values(?, ?)";// 저장될 테이블 이름수정하기

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, nick);
			psmt.setInt(2, score);

			int result = psmt.executeUpdate();

			if (result > 0) {
				check = true;
			} else {
				check = false;
			}
		} catch (Exception e) {
		} finally {
			close();
		}
		return check;
	}
	
	//점수 업데이트 메소드
	public void updateScore(int score, String nick) {
		try {
			connect();
			
			String sql = "update ranking set score = ? where nick = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, score);
			psmt.setString(2, nick);
			
			psmt.executeUpdate(sql);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	//점수 가져오는 메소드
	public int getuserScore(String nick) {
		try {
			connect();
			
			String sql = "select score from ranking where nick=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, nick);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				score = rs.getInt("score");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return score;
	}
	
	
}
