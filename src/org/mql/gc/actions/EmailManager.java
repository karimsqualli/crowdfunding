package org.mql.gc.actions;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.mql.gc.models.Association;
import org.mql.gc.models.Donor;

public class EmailManager {
	public EmailManager(){
	}
	
	public String getHtmlText(){
		String text="<!DOCTYPE html><html><head><title>activation link</title></head><body style=\"font-family: Georgia, seri\"><aside style=\"margin:40px;\"><div style=\"display: flex;justify-content: row;\"> <img src=\"https://image.ibb.co/kRZS3x/logo.png\"><p style=\"margin-top : 55px; font-size: 40px;color: rgb(0,232,0);font-weight: 200;\">Action requise : confirmez votre compte 3awni</p></div><hr><div><h2>Bonjour Hassan,</h2></div><div><p>Vous avez récemment créé un compte sur 3awni. Pour terminer votre inscription, veuillez confirmer votre compte.</p></div><div>";
		return text;
	}
	
	public String getLink(){
		String link="<input type=\"button\" style=\"height: 30px;width: 160px;background-color: rgba(0,255,0,0.8);font-family: Georgia, serif;border-radius:10%;cursor: pointer;box-shadow: 5px 5px 60px rgba(12,230,12,0.3);border: none; \"value=\"Activer votre compte\"/></a></div></aside></body></html>";
		return link ;
	}
	
	public void sendEmail(String key,Object obj){
		System.out.println(getLink());
		String htmlMessage=getHtmlText();
		HtmlEmail email = new HtmlEmail();
		String link=htmlMessage+"<a href=\"http://localhost:9085/Crowdf/activationLink2.xhtml?key="+key+""
				+ "&email="
				+((Donor) obj).getEmail()
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
			email.setFrom(((Donor) obj).getEmail());
			email.addTo(((Donor) obj).getEmail());
			email.setHtmlMsg(link);
			email.setSubject("activate ur account");
			email.send();
		} catch (EmailException e) {
			System.out.println("error seting form"+e.getMessage());
		}
	}
	
	public void sendEmailAssociation(String key,Object obj){
		System.out.println(getLink());
		String htmlMessage=getHtmlText();
		HtmlEmail email = new HtmlEmail();
		String link=htmlMessage+"<a href=\"http://localhost:9085/Crowdf/activationLink2.xhtml?key="+key+""
				+ "&email="
				+((Association) obj).getEmail()
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
			email.setFrom(((Association) obj).getEmail());
			email.addTo(((Association) obj).getEmail());
			email.setHtmlMsg(link);
			email.setSubject("activate ur account");
			email.send();
		} catch (EmailException e) {
			System.out.println("error seting form"+e.getMessage());
		}
	}
}
