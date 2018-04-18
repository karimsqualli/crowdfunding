package org.mql.gc.actions;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.mql.gc.models.Case;
import org.mql.gc.services.Service;
import org.mql.gc.utils.SessionUtils;

public class ShowCase implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nom;
	private String category;
	private Case cas;
	private List<Case> liste;
	private List<Case> listUrgent;
	private List<Case> listProximite;
	private Service service;
	private long resultat;
	private int listeLength;
	private boolean rendered;
	
	@PostConstruct
	public void init(){
		System.out.println("iciccicicicici"+liste);
		liste = service.getCases();
		listUrgent = service.getCasesUrgent();
		listeLength = liste.size();
		
		if(SessionUtils.getUserId() != null) {
			setRendered(true);
			int id = SessionUtils.getUserId();
			listProximite = service.getCases(service.getDonorById(id).getCity());
		System.out.println("session");
		}
		else {
			setRendered(false);
		listProximite = service.getCasesUrgent();
		}
	}
	
	public int daysBetween(Date d) {
		System.out.println("Le d: "+d);
	
		LocalDate l = new LocalDate(d.getTime());
		System.out.println("le l :"+l);
		int x = Days.daysBetween(LocalDate.now(),l).getDays();
		System.out.println(LocalDate.now());
		System.out.println(x);
		return x;
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

	public int getListeLength() {
		return listeLength;
	}

	public void setListeLength(int listeLength) {
		this.listeLength = listeLength;
	}

	public List<Case> getListProximite() {
		return listProximite;
	}

	public void setListProximite(List<Case> listProximite) {
		this.listProximite = listProximite;
	}

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}
	
}
