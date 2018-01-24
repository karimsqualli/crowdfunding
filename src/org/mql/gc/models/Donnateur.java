package org.mql.gc.models;

public class Donnateur {
	private int id;
	private String email ; 
	private String fName;
	private String lName; 
	private String adresse; 
	private String ville ;
	private String password ; 
	private String keyActive ; 
	
	public String getPassword() {
		return password;
	}

	public String getKeyActive() {
		return keyActive;
	}
	public void setKeyActive(String keyActive) {
		this.keyActive = keyActive;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	
	
}
