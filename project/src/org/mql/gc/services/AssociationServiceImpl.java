package org.mql.gc.services;

import java.util.List;

import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImpl;
import org.mql.gc.models.Association;

public class AssociationServiceImpl implements AssociationService {

	private AssociationDao dao=(AssociationDao) new AssociationDaoImpl();
	
	public void add(Association e) {
		System.out.println("service");
						
		if(nameExist(e.getName()))
			System.out.println("association existe deja ");
		else {
			dao.add(e);
			System.out.println("association ajoutée : "+e.getName());
		}
		
	}


	
	public Association edite(Association e) {
		return dao.edite(e);
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

	public boolean nameExist(String name) {
		if(dao.findByName(name)!= null) 
			return true ; 
		
		return false;
	}
}
