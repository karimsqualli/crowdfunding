package org.mql.gc.actions;

import java.util.List;
import javax.annotation.PostConstruct;
import org.mql.gc.models.Case;
import org.mql.gc.services.Service;

public class CaseValidation {
	private Service service ;
	private List<Case> caseObjects;
	private Case caseObject;
	
	@PostConstruct
	public void init(){
		System.out.println("&& post contruct caseValidation &&");
		caseObjects = service.getPendingCases();
		System.out.println("cette liste : " + caseObjects);
	}
	
	public String deleteCase(int id) {
		service.deleteCase(id);
		caseObjects = service.getCasesNotActivated();
		return "validateCase.xhtml?faces-redirect=true";
	}
	
	public String validateCase(Case caseObject) {
		caseObject.setPending(true);
		service.updateCase(caseObject);
		caseObjects = service.getCasesNotActivated();
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

	public Case getCaseObject() {
		return caseObject;
	}

	public void setCaseObject(Case caseObject) {
		this.caseObject = caseObject;
	}


	
	
}
