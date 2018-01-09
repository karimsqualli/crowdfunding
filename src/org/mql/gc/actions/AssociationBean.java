package org.mql.gc.actions;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.mql.gc.models.ActivitySector;
import org.mql.gc.models.Association;
import org.mql.gc.models.LowFormEnum;
import org.mql.gc.services.ServiceImpl;
import org.mql.gc.utils.SessionUtils;


public class AssociationBean  implements Serializable{

	private Association asso;
	private SelectItem[] SectorActivities; 
	private SelectItem[] lowForms;
	private ServiceImpl service ;	
		
	
	
	//added by hassan 09/01/2018
	public  AssociationBean(){
		System.out.println("$$  constructeur AssociationBean $$");
		asso = new Association();
		SectorActivities = new SelectItem[ActivitySector.values().length];
		lowForms = new SelectItem[LowFormEnum.values().length];
	}

	
	public String createAss() {
		service.add(asso);
		HttpSession session = SessionUtils.getSession();
		session.setAttribute("email", asso.getEmail());
		int idAsso=service.findByEmail(asso.getEmail()).getId();
		session.setAttribute("idAssociation", idAsso);
		FacesContext.getCurrentInstance().addMessage("terminate", new FacesMessage("Inscription r�ussi"));
		return "LoadCase?faces-redirect=true";
	}
	
	public Association getAsso() {
		return asso;
	}

	public void setAsso(Association asso) {
		this.asso = asso;
	}

	public SelectItem[] getLowForms() {
	    int i = 0;
	    for(LowFormEnum g: LowFormEnum.values()) {
	    	lowForms[i++] = new SelectItem(g.name(), g.name());
	    }
	    return lowForms;
	}


	

	public SelectItem[] getSectorActivities() {
	    int i = 0;
	    for(ActivitySector g: ActivitySector.values()) {
	    	SectorActivities[i++] = new SelectItem(g.name(), g.name());
	    }
	    return SectorActivities;
	}

	public void setLowForms(SelectItem[] lowForms) {
		this.lowForms = lowForms;
	}


	public ServiceImpl getService() {
		return service;
	}


	public void setService(ServiceImpl service) {
		this.service = service;
	}

	

}
