package entities;

public class User {

	private String nameUser;
	private int idUser;
	private TypeOfUser typeUser;

	public User(String nameUser, int idUser, TypeOfUser typeUser) {
		this.nameUser = nameUser;
		this.idUser = idUser;
		this.typeUser = typeUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public TypeOfUser getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(TypeOfUser typeUser) {
		this.typeUser = typeUser;
	}

	public String printUser() {
		return "Name: " + getNameUser() +
				"\nId: " + getIdUser() + 
				"\nType of user: " + getTypeUser();

	}

}
