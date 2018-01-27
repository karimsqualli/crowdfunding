package org.mql.gc.actions;


import java.io.Serializable;
import java.sql.Timestamp;
import org.mql.gc.models.Donation;
import org.mql.gc.services.Service;
import org.mql.gc.services.ServiceImpl;
import org.mql.gc.utils.SessionUtils;

public class DonationBean implements Serializable {
	
	private Donation donation;
	private Service service;
	
	public String createDonnation() {
		donation.setIdUser(SessionUtils.getUserId());
		initialiserDateInscription();
		service.addDonation(donation);
		return "index?faces-redirect=true";
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

	public void setService(ServiceImpl service) {
		this.service = service;
	}
}
