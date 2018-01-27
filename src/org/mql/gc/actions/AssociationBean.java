package org.mql.gc.actions;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.mql.gc.models.ActivitySector;
import org.mql.gc.models.Association;
import org.mql.gc.models.LegalForm;
import org.mql.gc.services.ServiceImpl;
import org.mql.gc.utils.SessionUtils;

public class AssociationBean  implements Serializable{
	private Association association;
	private SelectItem[] sectorActivities; 
	private SelectItem[] legalForm;
	private ServiceImpl service ;	

	//added by hassan 09/01/2018
	public  AssociationBean(){
		System.out.println("$$  constructeur AssociationBean $$");
		sectorActivities = new SelectItem[ActivitySector.values().length];
		legalForm= new SelectItem[LegalForm.values().length];
	}

	//???
	public String createAccount() {
		System.out.println("creating association");
		service.addAssociation(association);
		HttpSession session = SessionUtils.getSession();
		session.setAttribute("email", association.getEmail());
		session.setAttribute("idAssociation", association.getId());
		FacesContext.getCurrentInstance().addMessage("terminate", new FacesMessage("Inscription réussi"));
		return "LoadCase?faces-redirect=true";
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


	public ServiceImpl getService() {
		return service;
	}


	public void setService(ServiceImpl service) {
		this.service = service;
	}


	public void setSectorActivities(SelectItem[] sectorActivities) {
		this.sectorActivities = sectorActivities;
	}

	
	

}
