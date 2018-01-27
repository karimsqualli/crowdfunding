package org.mql.gc.actions;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.mql.gc.models.Cas;
import org.mql.gc.services.ServiceImpl;

public class CaseValidation implements Serializable{
	private static final long serialVersionUID = 1L;
	private ServiceImpl service = new ServiceImpl();
	private List<Cas> cas;


	@PostConstruct
	public void init(){
		cas = service.getPendingCases();
	}
	
	public List<Cas> getCas() {
		return cas;
	}

	public void setCas(List<Cas> cas) {
		this.cas = cas;
	}

	public ServiceImpl getService() {
		return service;
	}
	
	public void setService(ServiceImpl service) {
		this.service = service;
	}
	
}
