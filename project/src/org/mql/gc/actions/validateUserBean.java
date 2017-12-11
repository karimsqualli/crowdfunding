package org.mql.gc.actions;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mql.gc.models.User;
import org.mql.gc.services.UserDaoService;
import org.mql.gc.utils.SessionUtils;

@ManagedBean
@SessionScoped
public class validateUserBean {
	private User utilisateur;
	private UserDaoService service;

	public validateUserBean() {
		utilisateur = new User();
		service = new UserDaoService();
	}

	public String validateUtilisateur() {
		if (service.connectUser(utilisateur.getEmail(), utilisateur.getPassword())) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", utilisateur.getNom());
			return "user";
		}

		else {
			System.out.println("Else");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "login";
		}
	}

	public String validateAssociation() {
		if (service.connectUser(utilisateur.getEmail(), utilisateur.getPassword())) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", utilisateur.getNom());
			return "user";
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

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

}
