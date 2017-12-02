package org.mql.gc.actions;



import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.mql.gc.models.Association;
import org.mql.gc.services.AssociationService;
import org.mql.gc.services.AssociationServiceImpl;





@ManagedBean(name="AssBean")
@RequestScoped
public class AssociationBean {

	
	private String name;
	private String description;
	private String message;
	private boolean showForm; 
	private AssociationService service;
	private List<SelectItem> liste ; 
	private List<Association> listeTable ; 
	
	
	{
		System.err.println("saved done");
	}
	


	@PostConstruct
	public void init(){
		//here initialize of elements that we need 
		service=new AssociationServiceImpl();
	}
	

	
	public void saveAss(ActionEvent e){
		Association as=new Association();
		as.setDescription(description);
		as.setName(name);
		as.setId(1L);
		System.out.println("nom de l'association = "+as.getName());
		System.out.println("description = "+as.getDescription());	
		service.add(as);
		message="ajout réussie";
	}
	
	
	public void showListe(){
		List<Association> liste2=new ArrayList<Association>();
		liste2=new AssociationServiceImpl().findAll();
		for(Association as:liste2){
			liste.add(new SelectItem(as.getId(), as.getName()));
		}
	}

	public void afficherFormulaire(ActionEvent e){
		System.out.println("formulaire visible ");
		showForm = true ; 
	}
	
	public void cacherFormulaire(ActionEvent e){
		System.out.println("formulaire invisible ");
		showForm = false ; 
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public boolean isShowForm() {
		return showForm;
	}



	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}



	public AssociationService getService() {
		return service;
	}



	public void setService(AssociationService service) {
		this.service = service;
	}



	public List<SelectItem> getListe() {
		return liste;
	}



	public void setListe(List<SelectItem> liste) {
		this.liste = liste;
	}



	public List<Association> getListeTable() {
		return listeTable;
	}



	public void setListeTable(List<Association> listeTable) {
		this.listeTable = listeTable;
	}
	
	



	
	
	

}
