package org.mql.gc.models;

import java.sql.Timestamp;
import java.util.Date;

public class Donation {
	private int id;
	private int idCas;
	private int idUser;
	private double cout;
	private String numCb;
	private Date dateExpiration;
	private String ccv;
	private Timestamp dateAjout;	
	
		
	public Donation() {
	}

	public int getIdCas() {
		return idCas;
	}
	
	public void setIdCas(int idCas) {
		this.idCas = idCas;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public double getCout() {
		return cout;
	}
	
	public void setCout(double cout) {
		this.cout = cout;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("id="+id);
		this.id = id;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}


	public Timestamp getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Timestamp dateAjout) {
		this.dateAjout = dateAjout;
	}



	public String getCcv() {
		return ccv;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

	public String getNumCb() {
		return numCb;
	}

	public void setNumCb(String numCb) {
		this.numCb = numCb;
	}


	
}
