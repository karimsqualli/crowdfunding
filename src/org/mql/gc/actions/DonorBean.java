package org.mql.gc.actions;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.EmailException;
import org.mql.gc.models.Donor;
import org.mql.gc.services.Service;
import org.mql.gc.services.ServiceImpl;
import org.mql.gc.utils.SessionUtils;
import org.primefaces.context.RequestContext;

public class DonorBean {

	private Service service;
	private Donor donor;
	static boolean connected = false;
	
	//for activing account by link 	
	@PostConstruct
	public void init(){
		//===============check if donator try to participate in a case without logIn
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String message = (String) request.getAttribute("logDon");
		if(message != null && message.equals("notIn")){
			FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "connectez vous pour participer ! ","");
			RequestContext.getCurrentInstance().execute("PF('dlg').show();");
			RequestContext.getCurrentInstance().showMessageInDialog(message2);	
		}
		//==========================================
				
		
	}
	

	public String createAccount(){
        FacesMessage message = null;
        boolean subscribe = false;
		String key = UUID.randomUUID().toString() ; 
		donor.setKeyActive(key);
		RequestContext context = RequestContext.getCurrentInstance();
		if(!service.donorEmailExist(donor.getEmail())) {
			service.addDonor(donor);
	        message = new FacesMessage(FacesMessage.SEVERITY_INFO,"votre inscription a ete effectue avec succee", "");
	        subscribe = true; 
	        sendEmail(key);
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Email exite deja", "");
		}
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("sign_in", subscribe);
        return "index.xhtml?faces-redirect=true";
	}

	public String validateDonor() {
		System.out.println("********");
        boolean loggedIn = false;
		if (service.loginDonor(donor.getEmail(), donor.getPassword())) {
            loggedIn = true;
            connected = true;
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("userid", donor.getId());
			session.setAttribute("email", donor.getEmail());
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Email valide", ""));
			return "index.xhtml?faces-redirect=true";
		}
		else {
            loggedIn = false;
			System.out.println("Else");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou mot de passe invalide", ""));
		    return null;
		}
	}

	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		connected = false;
		return "index.xhtml?faces-redirect=true";
	}
	
	public void sendEmail(String key){
		HtmlEmail email = new HtmlEmail();
		System.err.println("key ===> " + key );
		String link="<a href=\"http://localhost:8083/Crowdf/activationLink.xhtml?key="+key+""
				+ "&email="
				+ donor.getEmail()
				+ "\">"; 
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.setAuthentication("hamza.berrada@usmba.ac.ma","1210754635");
		try {
			email.setFrom(donor.getEmail());
			email.addTo(donor.getEmail());
			email.setHtmlMsg("<html><body>"
					+ "<h1>hello fuckers ! how are you ?</h1> "+link
					+ "<br><em>PROJECT KAISSAHH SENT BY HASSAN TO THE FUCKER AHMED</em>"
					+ "</h1>"
					+ "</body></html>");
			email.setSubject("activate ur account");
			email.send();
		} catch (EmailException e) {
			System.out.println("error seting form"+e.getMessage());
		}
	
	}
	
	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	public Donor getDonor() {
		return donor;
	}


	public void setDonor(Donor donor) {
		this.donor = donor;
	}
	
	
	
	
}