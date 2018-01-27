package org.mql.gc.actions;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.mql.gc.models.Case;
import org.mql.gc.services.Service;

@ManagedBean
@ViewScoped
public class CaseValidation {
	@ManagedProperty(value="#{ServiceImp}")
	private Service service ;
	private List<Case> zmorixa;
	
	@PostConstruct
	public void innit(){
		System.out.println("&& post contruct caseValidation &&");
		zmorixa = service.getPendingCases();
		System.out.println("cette liste : " + zmorixa);
	}

	
	
	public List<Case> getZmorixa() {
		return zmorixa;
	}

	public void setZmorixa(List<Case> zmorixa) {
		this.zmorixa = zmorixa;
	}



	public Service getService() {
		return service;
	}



	public void setService(Service service) {
		this.service = service;
	}


	
	
}
