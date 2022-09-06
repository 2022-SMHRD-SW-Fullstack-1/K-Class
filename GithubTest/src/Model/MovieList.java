package Model;

public class MovieList {
	private String name;
	private String hint;
	private int lv;
	
	public MovieList(String name, String hint, int lv) {
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

	public int getLv() {
		return lv;
	}
	
}
