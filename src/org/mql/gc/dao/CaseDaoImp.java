package org.mql.gc.dao;

import org.hibernate.Session;
import org.mql.gc.models.Case;

public class CaseDaoImp implements CaseDao {
	private DataBase db;
	private Session session;
	
	public CaseDaoImp() {
		db = new DataBase();
		session = db.getSession();
	}
	
	public void saveCase(Case caseObject) {
		db.openSession();
		session.beginTransaction();
		session.save(caseObject);
		session.getTransaction().commit();
		db.closeSession();
	}
	
}
