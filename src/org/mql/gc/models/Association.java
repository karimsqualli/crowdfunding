package org.mql.gc.models;


public class Association{
	
	private Long id;
	private String email; 
	private String description;
	private String name ; 
	private String password ; 
	private String pattente;
	private String activityArea;
	private String LowForm;
	private String website;
	private String fixe; 
	private String gsm ; 


	public Association() {
	}
	
	
	public String getGsm() {
		return gsm;
	}



	public void setGsm(String gsm) {
		this.gsm = gsm;
	}



	public String getWebsite() {
		return website;
	}

	

	public String getFixe() {
		return fixe;
	}



	public void setFixe(String fixe) {
		this.fixe = fixe;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPattente() {
		return pattente;
	}

	public void setPattente(String pattente) {
		this.pattente = pattente;
	}

	public String getActivityArea() {
		return activityArea;
	}

	public void setActivityArea(String activityArea) {
		this.activityArea = activityArea;
	}

	public String getLowForm() {
		return LowForm;
	}

	public void setLowForm(String lowForm) {
		LowForm = lowForm;
	}

	
	
	
	
}