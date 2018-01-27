package org.mql.gc.models;

public class Donor {
	private int id;
	private String email; 
	private String firstName;
	private String lastName; 
	private String address; 
	private String city;
	private String password; 
	private String keyActive; 
	
	public Donor() {

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKeyActive() {
		return keyActive;
	}

	public void setKeyActive(String keyActive) {
		this.keyActive = keyActive;
	}
	
}