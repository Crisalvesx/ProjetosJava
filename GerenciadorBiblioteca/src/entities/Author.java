package entities;

public class Author {

	private String nameAuthor;
	private int idAuthor;
	private String nationality;

	public Author(String nameAuthor, int idAuthor, String nationality) {
		
		this.nameAuthor = nameAuthor;
		this.idAuthor = idAuthor;
		this.nationality = nationality;
	}

	public String getNameAuthor() {
		return nameAuthor;
	}

	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

	public int getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String printAuthor() {
		return "Name: " + getNameAuthor() +
				"\nId: " + getIdAuthor() +
				"\nNationality: " + getNationality();
	
	}

}
