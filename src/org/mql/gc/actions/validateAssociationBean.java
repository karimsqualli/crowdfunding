package org.mql.gc.actions;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.mql.gc.models.Association;
import org.mql.gc.services.Service;
import org.mql.gc.utils.SessionUtils;

public class validateAssociationBean {
	private Association association;
	private Service service;
	
	public String validateAssociation() {
		if (service.loginAssociation(association.getEmail(), association.getPassword())) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("email", association.getEmail());
			session.setAttribute("idAssociation", association.getId());
			return "LoadCase?faces-redirect=true";
		}
		
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "login";
		}
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String logout() {
		System.out.println("Log out");
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login.xhtml?faces-redirect=true";
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}
}