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
			String sql = "select * from movie_list where lv = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, lv);//난이도
			
			rs = psmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String hint = rs.getString("hint");
				String grade = rs.getString("lv");
				
				ml.add(new MovieList(name,hint,grade));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return ml;

	}
}
