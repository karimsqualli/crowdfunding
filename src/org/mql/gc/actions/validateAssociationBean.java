package org.mql.gc.actions;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.mql.gc.models.Association;
import org.mql.gc.services.ServiceImpl;
import org.mql.gc.utils.SessionUtils;

//hassan : est ce que on utilise cette classe dans notre projet ?  
public class validateAssociationBean {
	private Association association;
	private ServiceImpl service;
	
	public String validateAssociation() {
		boolean exist= service.connectAssociation(association.getEmail(), association.getPassword());
		if (exist) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("email", association.getEmail());
			int idAsso=service.findByEmail(association.getEmail()).getId();
			System.out.println("idAssociation :"+idAsso); 
			session.setAttribute("idAssociation", idAsso);
			return "LoadCase?faces-redirect=true";
		}
		else {
			System.out.println("Else");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Votre email ou mot de passe est incorrecte !", ""));
			return "login";
		}
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

	public ServiceImpl getService() {
		return service;
	}

	public void setService(ServiceImpl service) {
		this.service = service;
	}
}
