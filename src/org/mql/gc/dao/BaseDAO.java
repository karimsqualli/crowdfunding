package org.mql.gc.dao;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.identity.SybaseAnywhereIdentityColumnSupport;

public class BaseDAO {
	protected Session session;
	public BaseDAO() {
	}

	public void openSession() {
		System.out.println("OPENNING SESSION");
		Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure().buildSessionFactory();//.configure("config/hibernate.cfg.xml")
		session = sessionFactory.openSession();// hna tanhal session ahah
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
