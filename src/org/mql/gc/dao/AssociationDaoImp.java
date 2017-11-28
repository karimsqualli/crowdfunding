package org.mql.gc.dao;

import org.hibernate.Session;
import org.mql.gc.models.Association;

public class AssociationDaoImp implements AssociationDao {

	private DataBase db;
	private Session session;
	
	public AssociationDaoImp() {
		db = new DataBase();
		session = db.getSession();
	}
	
	public void createAccount(Association association) {
		db.openSession();
		session.beginTransaction();
		session.save(association);
		session.getTransaction().commit();
		db.closeSession();
	}
	
}
