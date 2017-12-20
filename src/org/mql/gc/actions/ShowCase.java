package org.mql.gc.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.mql.gc.models.Cas;
import org.mql.gc.services.Service;
import org.mql.gc.services.ServiceImpl;

public class ShowCase implements Serializable{
	
	private String nom;
	private String category;
	
	private Cas cas;
	private List<Cas> liste;
	private Service service;
	
	public ShowCase() {
		service=new ServiceImpl();
		list();
		System.out.println("AA");
	}
	

	public void searchCas() {
		
		System.out.println("test");
		System.out.println(nom);
		System.out.println(category);

		
		this.liste = this.service.afficherListcas("htr", "artisanat");
	}

	
	public void list() {
		liste=service.afficherListcas();
		for (Cas cas : liste) {
			System.out.println(cas);
		}
		System.out.println("list");
	}

	public Cas getCas() {
		return cas;
	}

	public void setCas(Cas cas) {
		this.cas = cas;
	}

	public double getRes(int id) {
		double ret = service.calc(id);
		System.out.println("ret is " + ret);
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
	
}
