package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieListDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

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

	public ArrayList<MovieList> movieList(String lv) {

		connect();

		ArrayList<MovieList> ml = new ArrayList<MovieList>();

		try {
			String sql = "select * from movie_list where grade = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, lv);//난이도
			
			rs = psmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String hint1 = rs.getString("hint1");
				String hint2 = rs.getString("hint2");
				String hint3 = rs.getString("hint3");
				String grade = rs.getString("grade");
				
				ml.add(new MovieList(name,hint1,hint2,hint3,grade));
			}

		} catch (Exception e) {
			System.out.println("중복된 아이디이거나 잘못된 형식입니다.");
		} finally {
			close();
		}
		return ml;

	}
}
