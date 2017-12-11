package org.mql.gc.models;




public class User {
	private int id;
	private String email;
	private String password;
	private String nom;
	
	public User() {

	}
	
	
	
	public User(int id, String email, String password, String nom) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nom = nom;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", nom=" + nom + "]";
	}
	
	
	
}
