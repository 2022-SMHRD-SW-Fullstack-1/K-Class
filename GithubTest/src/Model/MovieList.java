package Model;

public class MovieList {
	private String name;
	private String hint1;
	private String hint2;
	private String hint3;
	private String grade;
	
	public MovieList(String name, String hint1, String hint2, String hint3, String grade) {
		this.name=name;
		this.hint1=hint1;
		this.hint2=hint2;
		this.hint3=hint3;
		this.grade=grade;
	}


	public String getName() {
		return name;
	}

	public String getHint1() {
		return hint1;
	}

	public String getHint2() {
		return hint2;
	}

	public String getHint3() {
		return hint3;
	}
	public String getGrade() {
		return grade;
	}
	
}
