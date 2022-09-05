package Model;

public class Movie {

	private String movieName;

	private String musicPath; // 음악 파일의 경로를 저장하는 필드

	public Movie(String ostName, String musicPath) {
		this.movieName = ostName;
		this.musicPath = musicPath;
	}

	public String getMoviePath() {
		return musicPath;
	}

	public String getostName() {
		return movieName;
	}

}
