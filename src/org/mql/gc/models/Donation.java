package org.mql.gc.models;

import java.sql.Timestamp;
import java.util.Date;

public class Donation {
	private int id;
	private int idCase;
	private int idUser;
	private double cost;
	private String numBC;
	private Date expirationDate;
	private String ccv;
	private Timestamp addedDate;	
	
	public Donation() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCase() {
		return idCase;
	}

	public void setIdCase(int idCase) {
		this.idCase = idCase;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getNumBC() {
		return numBC;
	}

	public void setNumBC(String numBC) {
		this.numBC = numBC;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCcv() {
		return ccv;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

	public Timestamp getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Timestamp addedDate) {
		this.addedDate = addedDate;
	}
	
	
}
