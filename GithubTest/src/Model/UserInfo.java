package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserInfo {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	boolean check = false;

	public void connect() {
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

	public void close() {
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

	public boolean userInsert(String id, String pw, String nick) {
		try {
			connect();
			String sql = "insert into user values(?, ?, ?)";// 저장될 테이블 이름수정하기

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

	public boolean login(String id, String pw) {
		boolean checkL = false;

		try {
			connect();

			String sql = "select id, pw from user";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String get_id = rs.getString("id");
				String get_pw = rs.getString("pw");

				if (get_id.equals(id) && get_pw.equals(pw)) {
					checkL = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return checkL;
	}

	public void updateScore(int score, String id) {
		try {
			connect();

			String sql = "update user set score = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, score);
			psmt.setString(2, id);

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public int getScore(String id) {
		int score = 0;
		try {
			connect();

			String sql = "select id, score from user where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				String get_id = rs.getString("id");
				int get_score = rs.getInt("score");

				if (get_id.equals(id)) {
					score = get_score;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return score;
	}

	public ArrayList<user> rank() {
		ArrayList<user> al = new ArrayList<user>();
		try {
			connect();

			String sql = "select id, socre from user order by score desc";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				int score = rs.getInt("score");
				al.add(new user(id, score));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}
}
