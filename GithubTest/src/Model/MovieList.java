package Model;

public class MovieList {
	private String name;
	private String hint;
	private String lv;
	
	public MovieList(String name, String hint, String lv) {
		this.name=name;
		this.hint=hint;
		this.lv=lv;
	}


	public String getName() {
		return name;
	}

	public String getHint() {
		return hint;
	}

	public String getGrade() {
		return lv;
	}
	
}
