package org.mql.gc.services;

import java.util.List;
import org.mql.gc.models.Association;
import org.mql.gc.models.Case;
import org.mql.gc.models.Donation;
import org.mql.gc.models.Donor;

public interface Service {
    //**********************************Association**********************************
	public void addAssociation(Association association);
	public void updateAssociation(Association association);
	public void deleteAssociation(int id);
	public List<Association> getAssociations();
	public Association getAssociationById(int id);
	public Association getAssociationByEmail(String email);
	public boolean associationNameExist(String name);//?
	public boolean loginAssociation(String email,String password);
	public List<Association> getAssociationsNotActivated() ;
	//************************************Case**************************************
	public void addCase(Case caseObject);
	public List<Case> getCases();
	public List<Case> getCasesUrgent();
	public List<Case> getAssociations(String nom, String category);
	public List<Case> getPendingCases();
	//************************************Donateur**************************************
	public void addDonor(Donor donor) ;
	public void updateDonor(int id) ;
	public void deleteDonor(int id) ;
	public List<Donor> getDonors() ;
	public Donor getDonorById(int id) ;
	public boolean donorNameExist(String name);
	public boolean donorEmailExist(String email);
	public boolean loginDonor(String email, String password);
	public double getCostDonor(int id);
	//***********************************Donation****************************************
	public void addDonation(Donation donation);
	//***********************************Admin****************************************
	public boolean loginAdmin(String email, String password);
}
