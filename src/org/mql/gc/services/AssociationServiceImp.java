package org.mql.gc.services;

import org.mql.gc.dao.AssociationDao;
import org.mql.gc.dao.AssociationDaoImp;
import org.mql.gc.models.Association;

public class AssociationServiceImp implements AssociationService {

	private AssociationDao associationDao;
	
	public AssociationServiceImp() {
		associationDao = new AssociationDaoImp();
	}
	
	public void create(Association association) {
		associationDao.createAccount(association);
	}	
	
}
