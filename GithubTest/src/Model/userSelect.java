package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userSelect {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_k_0830_1";
			String db_pw = "smhrd1";

			conn = DriverManager.getConnection(url, db_id, db_pw);

			if (conn != null) {
				System.out.println("접속 성공!");
			} else {
				System.out.println("접속 실패");
			}

			String sql = "select * from student";// 조회할 테이블

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");//
				String nick = rs.getString("nick");
				int score = rs.getInt("score");

				System.out.println(id + " / " + nick + " / " + score);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 오류");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 오류");
		} finally {
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
	}
}
