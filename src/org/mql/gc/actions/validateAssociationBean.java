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
			if(service.isActivated(association.getEmail())){
				if(service.isPending(association.getEmail())) {
					HttpSession session = SessionUtils.getSession();
					session.setAttribute("email", association.getEmail());
					session.setAttribute("idAssociation", association.getId());
					return "LoadCase?faces-redirect=true";
				}
				else{
					System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
					FacesContext.getCurrentInstance().addMessage("conne", new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Votre compte est en cours de traitement, votre compte sera v�rifier dans un d�lai max 7 jours ", ""));
					return "login";
				}
				
			}
			else{
				FacesContext.getCurrentInstance().addMessage("conne", new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Veuillez activer votre email ! ", ""));
				return "login";
			}
		}
		else {
			FacesContext.getCurrentInstance().addMessage("conne", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Email ou password incorrecte", ""));
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