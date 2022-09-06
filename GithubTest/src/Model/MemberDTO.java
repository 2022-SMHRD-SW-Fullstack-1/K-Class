package Model;

public class MemberDTO {
	private String id;
	private String pw;
	private String nick;
	private int score;
	
	MemberDAO DAO = new MemberDAO();
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(String id, String pw, String nick, int score) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.score = score;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}


		

}
