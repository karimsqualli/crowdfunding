package org.mql.gc.actions;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.mql.gc.models.Case;
import org.mql.gc.services.Service;

public class CaseValidation {
	private Service service ;
	private List<Case> caseObjects;
	
	@PostConstruct
	public void init(){
		System.out.println("&& post contruct caseValidation &&");
		caseObjects = service.getPendingCases();
		System.out.println("cette liste : " + caseObjects);
	}
	
	//A faire : Mr karim
	public String deleteCase(int id) {
		return "validateCase.xhtml?faces-redirect=true";
	}
	
	//A faire : Mr karim
	public String validateCase(Case caseObject) {
		return "validateCase.xhtml?faces-redirect=true";
	}
	
	
	public List<Case> getCaseObjects() {
		return caseObjects;
	}

	public void setCaseObjects(List<Case> caseObjects) {
		this.caseObjects = caseObjects;
	}



	public Service getService() {
		return service;
	}



	public void setService(Service service) {
		this.service = service;
	}


	
	
}
