package org.mql.gc.actions;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.mql.gc.models.Cas;
import org.mql.gc.services.ServiceImpl;

public class ShowCase implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nom;
	private String category;
	private Cas cas;
	private List<Cas> liste;
	private List<Cas> listUrgent;
	private ServiceImpl service;
	
	@PostConstruct
	public void innit(){
		liste=service.afficherListcas();
	}
	
	public ServiceImpl getService() {
		return service;
	}
	
	public void setService(ServiceImpl service) {
		this.service = service;
	}
	
	public void searchCas() {
		this.liste = this.service.afficherListcas("htr", "artisanat");
	}

	public void listUrgent() {
		listUrgent=service.findAllUrgent();
		for (Cas cas : listUrgent) {
			System.out.println(cas);
		}
	}

	public Cas getCas() {
		return cas;
	}
	
	public void setCas(Cas cas) {
		this.cas = cas;
	}

	public double getRes(int id) {
		double ret = service.calc(id);
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
	
	public List<Cas> getListe() {
		return liste;
	}

	public void setListe(List<Cas> liste) {
		this.liste = liste;
	}

	public List<Cas> getListUrgent() {
		return listUrgent;
	}

	public void setListUrgent(List<Cas> listUrgent) {
		this.listUrgent = listUrgent;
	}
}
