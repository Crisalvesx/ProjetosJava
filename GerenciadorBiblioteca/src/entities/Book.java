package entities;

public class Book {

	private String title;
	private int idBook;
	private String author;
	private StatusBook status;

	public Book(String title, int idBook, String author, StatusBook status) {
		
		this.title = title;
		this.idBook = idBook;
		this.author = author;
		this.status = status;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public StatusBook getStatus() {
		return status;
	}

	public void setStatus(StatusBook status) {
		this.status = status;
	}
	
	public String printBook() {
		return "Title: " + getTitle() +
				"\nId: " + getIdBook() +
				"\nAuthor: " + getAuthor() +
				"\nStatus: " + getStatus();
	
	}


}
