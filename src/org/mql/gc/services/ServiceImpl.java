package org.mql.gc.services;

import java.util.Date;
import java.util.List;

import org.mql.gc.dao.AdminDao;
import org.mql.gc.dao.AdminDaoImp;
import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImp;
import org.mql.gc.dao.DonationDao;
import org.mql.gc.dao.DonationDaoImp;
import org.mql.gc.dao.DonorDao;
import org.mql.gc.dao.DonorDaoImp;
import org.mql.gc.dao.CaseDao;
import org.mql.gc.dao.CaseDaoImp;
import org.mql.gc.models.Association;
import org.mql.gc.models.Case;
import org.mql.gc.models.Donation;
import org.mql.gc.models.Donor;

public class ServiceImpl implements Service {
	
	
	private CaseDao caseDao;
	private AssociationDao associationDao;
	private DonorDao donorDao;
	private DonationDao donationDao;
	private AdminDao adminDao;

	
	public ServiceImpl() {
//		caseDao = new CaseDaoImp();
//		associationDao = new AssociationDaoImp();
//		donorDao = new DonorDaoImp();
//		donationDao = new DonationDaoImp();
//		adminDao = new AdminDaoImp();
	}
	
//******************************Association************************	
	public boolean isPending(String email) {
		return associationDao.isPending(email);
	}
	
	public boolean checkAccountStatusAss(String email, String key) {
		if(associationDao.select(email, key)!=null){
			return true;
		}
		return false;
	}

	public void activeAssAccount(String email, String key) {
		associationDao.active(email, key);
	}
	
	public boolean isActivated(String email){
		return associationDao.isActivated(email);
	}
	
	public void addAssociation(Association association) {
		if(nameExist(association.getName()))
			System.out.println("association existe deja ");
		else {
			associationDao.create(association);
			System.out.println("association ajout�e : " + association.getName());
		}
	}
	
	public boolean associationEmailExist(String email){
		if(associationDao.selectByEmail(email) != null) 
			return true ; 
		return false;
	}
	
	public void updateAssociation(Association association) {
		associationDao.update(association);
	}

	public void delete(int id) {
		associationDao.delete(id);
	}

	public List<Association> getAssociations() {
		return associationDao.select();
	}
	
	public Association getAssociationById(int id) {
		return associationDao.selectById(id);
	}
	
	public Association getAssociationByEmail(String email) {
		return associationDao.selectByEmail(email);
	}

	public boolean nameExist(String name) {
		if(associationDao.selectByName(name)!= null) 
			return true ; 	
		return false;
	}

	public boolean loginAssociation(String email, String password) {	
		return associationDao.login(email, password);
	}
	public List<Association> getAssociationsNotActivated() {
		return associationDao.selectNotActivated();
	}


//*********************************Cas*****************************************
	
	public void addCase(Case caseObject) {
		System.out.println("service");
		caseDao.create(caseObject); 
		System.out.println(caseObject);
	}

	public List<Case> getCases() {
		return caseDao.select();
	}
	
	public List<Case> getCases(String key,String category, String association, String ville, String title, Date date,
			double cost) {
		this.caseDao=new CaseDaoImp();
		return caseDao.getCases(key,category, association, ville, title, date, cost);
	}
	
	public List<Case> getCasesUrgent() {
		return caseDao.selectUrgent();
	}
	
	public List<Case> getCases(String title, String category) {
		return caseDao.select(title, category);
	}
	
	public List<Case> getCases(String city) {
		return caseDao.select(city);
	}
	
	public List<Case> getPendingCases() {
		return caseDao.findPending();
	}
	
	public void updateCase(Case caseObject) {
		caseDao.update(caseObject);
	}

	public void deleteCase(int id) {
		caseDao.deleteCase(id);
	}
	
	public List<Case> getCasesNotActivated() {
		return caseDao.findPending();
	}

	//********************************Donnateur*********************************************	
	
	

		public boolean isActivatedDonor(String email) {
			return donorDao.isActivated(email);

		}

		public void addDonor(Donor donor) {
			System.out.println("service");
			if(!donorEmailExist(donor.getEmail())){
				donorDao.create(donor);
			}
		}
		
		public void updateDonor(int id) {
			donorDao.update(id);
		}
		
		public void deleteDonator(int id) {
			donorDao.delete(id);
		}

		public List<Donor> getDonors() {
			System.out.println("nb " + donorDao.select().size());
			return donorDao.select();
		}
		
		
		public Donor getDonorById(int id) {
			return donorDao.selectById(id);
		}
		
		public Donor getDonor(String email) {
			return donorDao.selectByEmail(email);
		}

		public boolean donorNameExist(String name) {
			if(donorDao.selectByName(name) != null) 
				return true ; 
			return false;
		}
		
		public boolean donorEmailExist(String email) {
			if(donorDao.selectByEmail(email) != null) 
				return true ; 
			return false;
		}
		
		public boolean loginDonor(String email, String password) {
			return donorDao.login(email, password);
			
		}
		
		public boolean checkAccountStatus(String email,String key){
			donorDao = new DonorDaoImp();
			if(donorDao.select(email, key) != null ) {
				return true ; 
			}
			return false ;
		}
		
		public void activeAccount(String email,String key){
			donorDao =new DonorDaoImp();
			donorDao.activeAccount(email, key);
		}
//***************************************Admin********************************************		
		
		public boolean loginAdmin(String email, String password) {	
			return adminDao.login(email, password);
		}
		
//*********************************test for spring*****************************************
		public void sayTest(){
			System.out.println("��� test setvice ���");
		}
		
		@Override
		public void deleteAssociation(int id) {
			associationDao.delete(id);
		}

		@Override
		public boolean associationNameExist(String name) {
			return false;
		}

		public List<Case> getAssociations(String nom, String category) {			
			return null;
		}

		public void deleteDonor(int id) {
			donorDao.delete(id);
		}

		public double getCostDonor(int id) {
			return donationDao.selectCost(id);
		}
		
		public void addDonation(Donation donation) {
			donationDao.create(donation);
		}

		public CaseDao getCaseDao() {
			return caseDao;
		}

		public void setCaseDao(CaseDao caseDao) {
			this.caseDao = caseDao;
		}

		public AssociationDao getAssociationDao() {
			return associationDao;
		}

		public void setAssociationDao(AssociationDao associationDao) {
			this.associationDao = associationDao;
		}

		public DonorDao getDonorDao() {
			return donorDao;
		}

		public void setDonorDao(DonorDao donorDao) {
			this.donorDao = donorDao;
		}

		public DonationDao getDonationDao() {
			return donationDao;
		}

		public void setDonationDao(DonationDao donationDao) {
			this.donationDao = donationDao;
		}

		public AdminDao getAdminDao() {
			return adminDao;
		}

		public void setAdminDao(AdminDao adminDao) {
			this.adminDao = adminDao;
		}


		

}