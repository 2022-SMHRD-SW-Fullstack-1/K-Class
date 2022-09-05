package Model;

public class MemberDTO {

	private String id;
	private String pw;
	private String nick;
	private int score;

	public MemberDTO(String id, String nick, int score) {
		this.id = id;
		this.nick = nick;
	}

	public String getId() {
		return id;
	}

	public String getNick() {
		return nick;
	}

	public int getScore() {
		return score;
	}
}
