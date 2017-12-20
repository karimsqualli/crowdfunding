package org.mql.gc.actions;


import java.io.Serializable;
import java.sql.Timestamp;
import org.mql.gc.models.Donation;
import org.mql.gc.services.Service;
import org.mql.gc.services.ServiceImpl;
import org.mql.gc.utils.SessionUtils;


public class DonAction implements Serializable {
	private Donation donation;
	private Service service;
	
	
	public DonAction() {
		System.out.println("in Action");
		donation = new Donation();
		service = new ServiceImpl();
	}
	
	public String createDonnation() {
		donation.setIdUser(SessionUtils.getUserId());
		initialiserDateInscription();
		service.saveDonn(donation);
		return "index?faces-redirect=true";
	}
	
	private void initialiserDateInscription() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
        donation.setDateAjout(date);
    }
	

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}


	
	
}
