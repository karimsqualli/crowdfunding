package org.mql.gc.actions;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.mql.gc.models.ActivitySector;
import org.mql.gc.models.Association;
import org.mql.gc.models.LowFormEnum;
import org.mql.gc.services.ServiceImpl;


public class AssociationBean {

	private String email;
	private String password; 
	private String name ; 
	private String activityArea;
	private String LowForm;
	private SelectItem[] SectorActivities; 
	private SelectItem[] lowForms;
	private String description ; 
	private String pattente;
	private ServiceImpl service ;
	private String website; 
	private String fixe;
	private String gsm ; 
	
	
	@PostConstruct
	public void init(){
		service = new ServiceImpl(); 
	}
	

	
	public void createAccount(ActionEvent e){
		System.out.println("in create account");
		
		Association ass = new Association();
		ass.setEmail(email);
		ass.setPassword(password);
		ass.setName(name);
		ass.setActivityArea(activityArea);
		ass.setLowForm(LowForm);
		ass.setDescription(description);
		ass.setPattente(Integer.parseInt(pattente));
		ass.setWebsite(website);
		ass.setFixe(fixe);
		ass.setGsm(gsm);
		service.add(ass);
		FacesContext.getCurrentInstance().addMessage("terminate", new FacesMessage("inscription done"));
	
	}
	
	
	
	
	public String getGsm() {
		return gsm;
	}


	public void setGsm(String gsm) {
		this.gsm = gsm;
	}


	public String getFixe() {
		return fixe;
	}


	public void setFixe(String fixe) {
		this.fixe = fixe;
	}


	public String getPattente() {
		return pattente;
	}




	public void setPattente(String pattente) {
		this.pattente = pattente;
	}




	public SelectItem[] getLowForms() {
		lowForms = new SelectItem[LowFormEnum.values().length];
	    int i = 0;
	    for(LowFormEnum g: LowFormEnum.values()) {
	    	lowForms[i++] = new SelectItem(g.name(), g.name());
	    }
	    return lowForms;
	}


	

	public SelectItem[] getSectorActivities() {
		SectorActivities = new SelectItem[ActivitySector.values().length];
	    int i = 0;
	    for(ActivitySector g: ActivitySector.values()) {
	    	SectorActivities[i++] = new SelectItem(g.name(), g.name());
	    }
	    return SectorActivities;
	}

	public void setLowForms(SelectItem[] lowForms) {
		this.lowForms = lowForms;
	}

	public String getLowForm() {
		return LowForm;
	}


	public void setLowForm(String lowForm) {
		LowForm = lowForm;
	}



	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	




	public String getActivityArea() {
		return activityArea;
	}


	public void setActivityArea(String activityArea) {
		this.activityArea = activityArea;
	}


	public String getPassword() {
		return password;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public void setSectorActivities(SelectItem[] sectorActivities) {
		SectorActivities = sectorActivities;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public ServiceImpl getService() {
		return service;
	}


	public void setService(ServiceImpl service) {
		this.service = service;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	
	
/*	
 * 
 * 
 * 
 * 
 * 
 * 
 
 	
	public void saveAss(ActionEvent e){
	Association as=new Association();
		as.setDescription(description);
		as.setEmail(email);
		as.setId(1L);
		System.out.println("nom de l'association = "+as.getEmail());
		System.out.println("description = "+as.getDescription());	
		service.add(as);
		message="ajout réussie"; 

	}

 
 
 public void deleteAssociation(ActionEvent e){
		FacesContext fc=FacesContext.getCurrentInstance();
		Map<String, String> parametre=fc.getExternalContext().getRequestParameterMap();
		service.delete(new Long(parametre.get("id")));
		listeTable=service.findAll();

	}
	
	
	public void showListe(){
		List<Association> liste2=new ArrayList<Association>();
		liste2=new AssociationServiceImpl().findAll();
		for(Association as:liste2){
			liste.add(new SelectItem(as.getId(), as.getEmail()));
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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
	
	

*/

	
	
	

}
