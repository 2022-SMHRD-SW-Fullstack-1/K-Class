package Model;

public class ostModel {

	private String ostName;

	private String musicPath; // 음악 파일의 경로를 저장하는 필드

	public ostModel(String ostName) {
		this.ostName = ostName;
	}

	public String getMusicPath() {
		return musicPath;
	}

	public String getostName() {
		return ostName;
	}

}
