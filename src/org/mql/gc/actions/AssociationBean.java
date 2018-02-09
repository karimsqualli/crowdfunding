package org.mql.gc.actions;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import org.mql.gc.models.ActivitySector;
import org.mql.gc.models.Association;
import org.mql.gc.models.LegalForm;
import org.mql.gc.services.Service;
import org.mql.gc.services.ServiceImpl;
import org.mql.gc.utils.SessionUtils;

public class AssociationBean  implements Serializable{
	private Association association;
	private SelectItem[] sectorActivities; 
	private SelectItem[] legalForm;
	private Service service ;	
	private List<Association> associations;
	private int listeLength;
	

	//added by hassan 09/01/2018
	@PostConstruct
	public  void init(){
		listeLength=service.getAssociations().size();
		associations=service.getAssociationsNotActivated();
	}
	public AssociationBean() {
		service=new ServiceImpl();
		System.out.println("$$  constructeur AssociationBean $$");
		sectorActivities = new SelectItem[ActivitySector.values().length];
		legalForm= new SelectItem[LegalForm.values().length];
	}

	//???
	public String createAccount() {
		try {
		String gRecaptchaResponse = FacesContext.getCurrentInstance().
		getExternalContext().getRequestParameterMap().get("g-recaptcha-response");
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		if(verify){
			System.out.println(association.getEmail() + "Heree");
			System.out.println(service.associationEmailExist(association.getEmail()));
			if(!service.associationEmailExist(association.getEmail())) {
				initialiserDateInscription();
				association.setPending(false);
				service.addAssociation(association);
//				HttpSession session = SessionUtils.getSession();
//				session.setAttribute("email", association.getEmail());
//				session.setAttribute("idAssociation", association.getId());
				return "LoadCase?faces-redirect=true";
			}
			else {
				System.out.println("existe");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Email déja exsit ",""));
				return "login";
			}
		 }
				        
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
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


}
