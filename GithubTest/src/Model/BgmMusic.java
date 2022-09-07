package Model;

public class BgmMusic {

	private String name;
	private String musicPath; // 음악 파일의 경로를 저장하는 필드
	

	public BgmMusic(String name, String musicPath) {
		this.name = name;
		this.musicPath = musicPath;
	}

	public String getName() {
		return name;
	}

	public String getMusicPath() {
		return musicPath;
	}

}
