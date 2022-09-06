package Model;

public class MovieListDTO {
	private String name;
	private String hint;
	private int lv;
	private String moviepath;
	
	public MovieListDTO(String name, String hint, int lv, String moviepath) {
		this.name=name;
		this.hint=hint;
		this.lv=lv;
		this.moviepath=moviepath;
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
	
	public String getmoviepath() {
		return moviepath;
	}
}
