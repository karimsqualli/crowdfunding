package org.mql.gc.actions;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	private long resultat;
	
	@PostConstruct
	public void init(){
		System.out.println("iciccicicicici"+liste);
		liste = service.getCases();
		listUrgent = service.getCasesUrgent();
		
//		for (Case c : liste) {
//			Date now = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss"); 
//			    resultat = 0; 
//			    try { 
//			    	Date d1= sdf.parse(now.toString());
//			    	Date d2=sdf.parse(c.getEndDate().toString());
//			        resultat = d2.getTime() - d1.getTime(); 
//			    } catch (Exception e) { 
//			    	System.out.println("erreur resultat"+e.getMessage());
//			        e.printStackTrace(); 
//			    } 
//			    System.out.println("Il y a comme ecart :"+resultat); 
//		}

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


	public long getResultat() {
		return resultat;
	}


	public void setResultat(long resultat) {
		this.resultat = resultat;
	}

	
}
