package org.mql.gc.actions;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.mail.internet.MimeBodyPart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.HtmlEmail;
import org.apache.coyote.http11.filters.BufferedInputFilter;
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
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Email exite déjà", "");
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
	
	public String getHtmlText(){
		String text="<!DOCTYPE html><html><head><title>activation link</title></head><body style=\"font-family: Georgia, seri\"><aside style=\"margin:40px;\"><div style=\"display: flex;justify-content: row;\"> <img src=\"https://image.ibb.co/kRZS3x/logo.png\"><p style=\"margin-top : 55px; font-size: 40px;color: rgb(0,232,0);font-weight: 200;\">Action requise : confirmez votre compte 3awni</p></div><hr><div><h2>Bonjour Hassan,</h2></div><div><p>Vous avez récemment créé un compte sur 3awni. Pour terminer votre inscription, veuillez confirmer votre compte.</p></div><div>";
		return text;
	}
	
	public String getLink(){
		String link="<input type=\"button\" style=\"height: 30px;width: 160px;background-color: rgba(0,255,0,0.8);font-family: Georgia, serif;border-radius:10%;cursor: pointer;box-shadow: 5px 5px 60px rgba(12,230,12,0.3);border: none; \"value=\"Activer votre compte\"/></a></div></aside></body></html>";
		return link ;
	}
	
	public void sendEmail(String key){
		System.out.println(getLink());
		String htmlMessage=getHtmlText();
		HtmlEmail email = new HtmlEmail();
		String link=htmlMessage+"<a href=\"http://localhost:9085/Crowdf/activationLink2.xhtml?key="+key+""
				+ "&email="
				+ donor.getEmail()
				+"\">"
				+ getLink()
				; 
		System.out.println(link);
		email.setCharset("utf-8");
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.setAuthentication("hamza.berrada@usmba.ac.ma","1210754635");
		try {
			email.setFrom(donor.getEmail());
			email.addTo(donor.getEmail());
			email.setHtmlMsg(link);
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