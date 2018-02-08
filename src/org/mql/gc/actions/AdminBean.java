package org.mql.gc.actions;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.mql.gc.models.Admin;
import org.mql.gc.services.Service;
import org.mql.gc.utils.SessionUtils;

public class AdminBean {

	private Service service;
	private Admin admin;
	static boolean connected = false;

	@PostConstruct
	public  void init(){
	}
	
	public AdminBean() {
	}
	
	public String validateAdmin() {
		if (service.loginAdmin(admin.getEmail(), admin.getPassword())) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("email", admin.getEmail());
			session.setAttribute("idAdmin", admin.getId());
			return "validateCase?faces-redirect=true";
		}
		
		else {
			System.out.println("Else");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "loginAdmin";
		}
	}

	public String logOut() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "loginAdmin.xhtml?faces-redirect=true";
	}
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public static boolean isConnected() {
		return connected;
	}

	public static void setConnected(boolean connected) {
		AdminBean.connected = connected;
	}
	
}
