package org.mql.gc.actions;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.mql.gc.services.ServiceImpl;

public class Activation {

	Map<String, String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	String key = params.get("key");
	String email = params.get("email"); 
	private ServiceImpl service ;

    private boolean valid=false;

    @PostConstruct
    public void init() {
    	System.out.println("post constructeur---------------");
    	if(service.checkAccountStatus(email,key)){
    		service.activeAccount(email, key);
    		valid=true; 
    	}
    	else {
    		valid=false ; 
    	}
    }
    
    public Activation(){
    	System.out.println("constructeur -----------------");
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