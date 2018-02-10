package org.mql.gc.actions;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.mql.gc.models.ActivitySector;
import org.mql.gc.models.Association;
import org.mql.gc.models.LegalForm;
import org.mql.gc.services.Service;
import org.mql.gc.services.ServiceImpl;

public class AssociationBean  implements Serializable{
	private Association association;
	private SelectItem[] sectorActivities; 
	private SelectItem[] legalForm;
	private Service service ;	
	private List<Association> associations;
	private int listeLength;
	private EmailManager emailManager;
	
	private List<Association> listAssociations;
	

	//added by hassan 09/01/2018
	@PostConstruct
	public  void init(){
		listeLength=service.getAssociations().size();
		associations=service.getAssociationsNotActivated();
		listAssociations=service.getAssociations();
	}
	
	public AssociationBean() {
		service=new ServiceImpl();
		emailManager=new EmailManager();
		sectorActivities = new SelectItem[ActivitySector.values().length];
		legalForm= new SelectItem[LegalForm.values().length];
	}
		

	public String createAccount() {
		try {
		String gRecaptchaResponse = FacesContext.getCurrentInstance().
		getExternalContext().getRequestParameterMap().get("g-recaptcha-response");
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

		if(verify){
			if(!service.associationEmailExist(association.getEmail())) {
				String key = UUID.randomUUID().toString() ; 
				association.setKeyActive(key);
				emailManager.sendEmailAssociation(key, association);
				 
				initialiserDateInscription();
				association.setPending(false);
				service.addAssociation(association);
				return "LoadCase?faces-redirect=true";
			}
			else {
				FacesContext.getCurrentInstance().addMessage("inscri", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Email existe dèja",""));

				return "login";
			}
		 }
				        
		else{
			FacesContext.getCurrentInstance().addMessage("inscri", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Veuillez cocher le Re-Captcha ",""));
			return "login";
					          }
		} catch (Exception e) {return null;}		
			         
	}
	
	public String deleteAccount(int id) {
		service.deleteAssociation(id);
		associations = service.getAssociationsNotActivated();
	return "validateAssociation.xhtml?faces-redirect=true";
	}
	
	public String validateAssociation(Association association) {
		association.setPending(true);
		service.updateAssociation(association);
		associations = service.getAssociationsNotActivated();
		return "validateAssociation.xhtml?faces-redirect=true";
	}

	private void initialiserDateInscription() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
        association.setAddedDate(date);
    }

	public SelectItem[] getLowForms() {
	    int i = 0;
	    for(LegalForm g: LegalForm.values()) {
	    	legalForm[i++] = new SelectItem(g.name(), g.name());
	    }
	    return legalForm;
	}

	public SelectItem[] getSectorActivities() {
	    int i = 0;
	    for(ActivitySector g: ActivitySector.values()) {
	    	sectorActivities[i++] = new SelectItem(g.name(), g.name());
	    }
	    return sectorActivities;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public SelectItem[] getLegalForm() {
		return legalForm;
	}

	public void setLegalForm(SelectItem[] legalForm) {
		this.legalForm = legalForm;
	}


	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public void setSectorActivities(SelectItem[] sectorActivities) {
		this.sectorActivities = sectorActivities;
	}

	public List<Association> getAssociations() {
		return associations;
	}

	public void setAssociations(List<Association> associations) {
		this.associations = associations;
	}

	public int getListeLength() {
		return listeLength;
	}
	public void setListeLength(int listeLength) {
		this.listeLength = listeLength;
	}
	public List<Association> getListAssociations() {
		return listAssociations;
	}
	public void setListAssociations(List<Association> listAssociations) {
		this.listAssociations = listAssociations;
	}
	
	

}
