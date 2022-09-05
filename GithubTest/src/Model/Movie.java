package Model;

public class Movie {

	private String name;
	private String musicPath; // 음악 파일의 경로를 저장하는 필드
	private String hint;

	public Movie(String name, String musicPath, String hint) {
		this.name = name;
		this.musicPath = musicPath;
		this.hint = hint;
	}

	public String getMoviePath() {
		return musicPath;
	}

	public String getostName() {
		return name;
	}

	public String getHint() {
		return hint;
	}
}
