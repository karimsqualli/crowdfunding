package org.mql.gc.services;

import java.util.List;
import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.DonateurDaoImpl;
import org.mql.gc.dao.CaseDao;
import org.mql.gc.models.Association;
import org.mql.gc.models.Cas;
import org.mql.gc.models.Donation;
import org.mql.gc.models.Donnateur;

public class ServiceImpl implements Service {
	
	private CaseDao casDao;
	private AssociationDao dao;
	private DonateurDaoImpl DonatorDao;

	
	public ServiceImpl() {
		
	}
	
	
	public CaseDao getCasDao() {
		return casDao;
	}

	public void setCasDao(CaseDao casDao) {
		this.casDao = casDao;
	}

	public AssociationDao getDao() {
		return dao;
	}

	public void setDao(AssociationDao dao) {
		this.dao = dao;
	}

	public DonateurDaoImpl getDonatorDao() {
		return DonatorDao;
	}

	public void setDonatorDao(DonateurDaoImpl donatorDao) {
		DonatorDao = donatorDao;
	}


	
//******************************Association************************	

	public void add(Association e) {
						
		if(nameExist(e.getName()))
			System.out.println("association existe deja ");
		else {
			dao.create(e);
			System.out.println("association ajout�e : "+e.getName());
		}
	}
	
	public Association edite(Association e) {
		return dao.update(e);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	public List<Association> findAll() {
		return dao.findAll();
	}
	
	public Association findById(Long id) {
		return dao.findById(id);
	}
	public Association findByEmail(String email) {
		return dao.findByEmail(email);
	}

	public boolean nameExist(String name) {
		if(dao.findByName(name)!= null) 
			return true ; 	
		return false;
	}

	public boolean connectAssociation(String email, String password) {	
		return dao.loginAssociation(email, password);
	}

//*********************************Cas*****************************************
	
	public void create(Cas cas) {
		System.out.println("service");
		casDao.create(cas); 
		System.out.println(cas);
	}
	
	public List<Cas> afficherListcas() {
		return casDao.findAll();
	}
	
	public List<Cas> findAllUrgent() {
		return casDao.findAllUrgent();
	}
	
	
	public List<Cas> afficherListcas(String nom, String category) {
		return casDao.findByTitleAndCategory(nom ,category);
	}
	
	public List<Cas> getPendingCases() {
		return casDao.findPending();
	}
	
	
	
	//********************************Donnateur*********************************************	
		public boolean addDonator(Donnateur e) {
			System.out.println("service");
			if(emailDonatorExist(e.getEmail())){
				return false;
			}
			else {
				DonatorDao.create(e);
				return true ; 
			}	
		}
		public Donnateur editeDonator(Donnateur e) {
			return DonatorDao.update(e);
		}

		
		public void deleteDonator(int id) {
			DonatorDao.delete(id);
		}

		
		public List<Donnateur> findAllDonator() {
			return DonatorDao.findAll();
		}
		
		public Donnateur findDonatorById(int id) {
			return DonatorDao.findById(id);
		}

		public boolean nameDonatorExist(String name) {
			if(DonatorDao.findByName(name)!= null) 
				return true ; 
			return false;
		}
		
		public boolean emailDonatorExist(String email) {
			if(DonatorDao.findByEmail(email)!= null) 
				return true ; 
			return false;
		}
		
		public boolean passwordDonatorExist(String password) {
			if(DonatorDao.findByPassword(password)!= null) 
				return true ; 
			return false;
		}
		
		public Donnateur connectDonator(String email, String password) {
			return DonatorDao.loginDonator(email, password);
			
		}
		
		public void saveDonn(Donation donn) {
			DonatorDao.saveDonn(donn);
		}
		
		public double calc(int id) {
			return casDao.getDonatorCasCount(id);
		}
		
		public boolean checkAccountStatus(String email,String key){
			DonatorDao=new DonateurDaoImpl();
			if((DonatorDao.findBykeyAndEmail(email, key)) != null ) {
				return true ; 
			}
			return false ;
		}
		
		public void activeAccount(String email,String key){
			DonatorDao=new DonateurDaoImpl();
			DonatorDao.activeAccount(email, key);
		
		}
//*********************************test for spring*****************************************
		public void sayTest(){
			System.out.println("��� test setvice ���");
		}

}