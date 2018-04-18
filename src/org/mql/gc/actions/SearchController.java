package org.mql.gc.actions;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.mql.gc.models.ActivitySector;
import org.mql.gc.models.Case;
import org.mql.gc.models.City;
import org.mql.gc.services.Service;
import org.mql.gc.services.ServiceImpl;


public class SearchController {
	private  List<Case> data;
	private  Service service; 
//	public List<Case> getCases(String category,String association,String ville,String title,Date date,double cost);
	private Case cas; 
	private String association; 
	private String category; 
	private String ville;
	private String title;
	private Date date; 
	private double cost; 
	private String key;
	private List<String> liste;
	private List<String> cities; 
	
	
	
	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public String getKey() {
		return key;
	}	

	public void setKey(String key) {
		this.key = key;
	}

	
	@PostConstruct
	public void init(){
		System.out.println("SearchController.data");
		initListe();
		initListeCities();
		data=new Vector<>();
		service=new ServiceImpl(); 
		data=service.getCases();
	}
	
	public List<String> getListe() {
		return liste;
	}

	public void setListe(List<String> liste) {
		this.liste = liste;
	}

	public  void searchCase(){
		data.clear();
		data=service.getCases(key,category, association, ville, title, date, cost); 
		if(data.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("errorSearch", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"no result found !", ""));
			data=service.getCases();
			setAssociation(null);
			setCas(null);
			setCategory(null);
			setCost(0);
			setKey(null);
			setVille(null);
			setTitle(null);
			setDate(null);
		}
		
	}
	
	public void initListe() {
		liste = new Vector<>();
		for(ActivitySector e:ActivitySector.values()) {
			liste.add(e.name()); 
		}
	}
	
	public void initListeCities() {
		cities=new Vector<>(); 
		for(City ville: City.values()) {
			cities.add(ville.name());
		}
	}
	public List<Case> getData() {
		return data;
	}

	public void setData(List<Case> data) {
		this.data = data;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Case getCas() {
		return cas;
	}

	public void setCas(Case cas) {
		this.cas = cas;
	}

	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	

	

	
}
