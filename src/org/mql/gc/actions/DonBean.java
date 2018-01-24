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
import org.mql.gc.models.Donnateur;
import org.mql.gc.services.ServiceImpl;
import org.mql.gc.utils.SessionUtils;
import org.primefaces.context.RequestContext;

public class DonBean {

	private ServiceImpl service ;
	private Donnateur don;
	private boolean connected = false;
	
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
	
	public Donnateur getDon() {
		return don;
	}

	public void setDon(Donnateur don) {
		this.don = don;
	} 

	public String createDonator(){
        FacesMessage message =null;
        boolean subscribe=false;
		String key=UUID.randomUUID().toString() ; 
		don.setKeyActive(key);
		RequestContext context = RequestContext.getCurrentInstance();
		if(service.addDonator(don)){
	        message= new FacesMessage(FacesMessage.SEVERITY_INFO,"votre inscription a ete effectue avec succee", "");
	        subscribe=true; 
	        sendEmail(key);
		}
		else{
	        message= new FacesMessage(FacesMessage.SEVERITY_FATAL, "Email exite deja", "");
		}
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("sign_in", subscribe);
        return "index.xhtml?faces-redirect=true";
	}

	public String validateDonator(ActionEvent E) {
        boolean loggedIn = false;
		RequestContext context = RequestContext.getCurrentInstance();
		if (service.connectDonator(don.getEmail(), don.getPassword()) != null) {
            loggedIn = true;
            connected = true;
			don=service.connectDonator(don.getEmail(), don.getPassword());
			System.out.println(don.getfName());
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("userid", don.getId());
			session.setAttribute("username", don.getEmail());
			session.setAttribute("donnateur",don.getfName());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Welcome "+don.getfName(),"");
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
	        context.addCallbackParam("loggedIn", loggedIn);
			return "index.xhtml?faces-redirect=true";
		}
		else {
            loggedIn = false;
			System.out.println("Else");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou Password incorect","");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		     context.addCallbackParam("loggedIn", loggedIn);
		     return null;
		}
	}
	
	public ServiceImpl getService() {
		return service;
	}

	public void setService(ServiceImpl service) {
		this.service = service;
	}

	public String logoutt() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index.xhtml?faces-redirect=true";
	}
	
	public void sendEmail(String key){
		HtmlEmail email = new HtmlEmail();
		System.err.println("key ===> " + key );
		String link="<a href=\"http://localhost:9085/Crowdf/activationLink.xhtml?key="+key+""
				+ "&email="
				+ don.getEmail()
				+ "\">"; 
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setSSLOnConnect(true);
		email.setAuthentication("hassounnambz@gmail.com","me*feight=>elmzabi");
		try {
			email.setFrom(don.getEmail());
			email.addTo(don.getEmail());
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
}