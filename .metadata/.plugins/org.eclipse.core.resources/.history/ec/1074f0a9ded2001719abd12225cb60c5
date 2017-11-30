package org.mql.gc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataBase {
	Session session;
	
	public DataBase() {

	}
	
	public void openSession() {
		Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public void closeSession() {
		session.close();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
}
