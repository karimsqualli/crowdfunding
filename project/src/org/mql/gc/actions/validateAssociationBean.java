package org.mql.gc.actions;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mql.gc.dao.AssociationDao;
import org.mql.gc.models.Association;
import org.mql.gc.services.Service;
import org.mql.gc.services.ServiceImpl;
import org.mql.gc.utils.SessionUtils;

@ManagedBean
@SessionScoped
public class validateAssociationBean {
	private Association association;
	private ServiceImpl service;

	public validateAssociationBean() {
		association=new Association();
		service = new ServiceImpl();
	}

	public String validateAssociation() {
		if (service.connectAssociation(association.getEmail(), association.getPassword())) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", association.getName());
			return "menuAssociation";
		}

		else {
			System.out.println("Else");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "login";
		}
	}


	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	

}
