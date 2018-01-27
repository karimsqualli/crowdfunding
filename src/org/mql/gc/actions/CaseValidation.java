package org.mql.gc.actions;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.mql.gc.models.Cas;
import org.mql.gc.services.ServiceImpl;

public class CaseValidation implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Cas> cases;
	private ServiceImpl service;
	
	@PostConstruct
	public void init(){
		cases = service.getPendingCases();
	}
	
	public ServiceImpl getService() {
		return service;
	}
	
	public void setService(ServiceImpl service) {
		this.service = service;
	}
	
}
