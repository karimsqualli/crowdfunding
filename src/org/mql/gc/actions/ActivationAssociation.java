package org.mql.gc.actions;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.mql.gc.services.ServiceImpl;

@ManagedBean
@RequestScoped
public class ActivationAssociation {

	Map<String, String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	String key = params.get("key");
	String email = params.get("email"); 
	private ServiceImpl service ;
    private boolean valid=false;//
    
    @PostConstruct
    public void init() {
    	if(service.checkAccountStatusAss(email, key)){
    		service.activeAssAccount(email, key);
    		valid=true; 
    	}
    	else {
    		valid=false ; 
    	}
    }
    
    public ActivationAssociation(){
    	service = new ServiceImpl(); 
    }
    
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
    
    
}