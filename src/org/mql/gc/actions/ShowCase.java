package org.mql.gc.actions;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.mql.gc.models.Case;
import org.mql.gc.services.Service;

public class ShowCase implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nom;
	private String category;
	private Case cas;
	private List<Case> liste;
	private List<Case> listUrgent;
	private Service service;
	
	@PostConstruct
	public void init(){
		liste = service.getCases();
		listUrgent = service.getCasesUrgent();
	}
	
	public void searchCas() {
	}

	public Case getCas() {
		return cas;
	}
	
	public void setCas(Case cas) {
		this.cas = cas;
	}

	public double getRes(int id) {
		double ret = service.getCostDonor(id);
		return ret;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public List<Case> getListe() {
		return liste;
	}

	public void setListe(List<Case> liste) {
		this.liste = liste;
	}

	public List<Case> getListUrgent() {
		return listUrgent;
	}

	public void setListUrgent(List<Case> listUrgent) {
		this.listUrgent = listUrgent;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
}
