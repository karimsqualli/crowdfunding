package org.mql.gc.actions;

import java.sql.Timestamp;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.mql.gc.models.Donation;
import org.mql.gc.services.Service;
import org.mql.gc.utils.SessionUtils;



public class ValidateDonation {

	private Donation donation;
	private Service service;
	
	
	public ValidateDonation() {
		// TODO Auto-generated constructor stub
		System.out.println("test");
	}

	public void innit() {
		donation.setIdUser(SessionUtils.getUserId());
		initialiserDateInscription();
		service.addDonation(donation);
		FacesContext.getCurrentInstance().getApplication()
		.getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "index.xhtml");


	}
	
	private void initialiserDateInscription() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
        donation.setAddedDate(date);
    }
	
	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}
