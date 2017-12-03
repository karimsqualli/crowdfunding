package org.mql.gc.dao;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class BaseDAO {
	
	protected Session session=null ; 
	private String source="C:/Users/ExtraHassan/Documents/GitHub/crowdfunding/src/Hibernate.cfg.xml";
	File hibernatePropsFile = new File(source);
	
	protected void startSession(){
		session=new Configuration().configure(hibernatePropsFile).buildSessionFactory().openSession();
		session.beginTransaction();
	}
	
	protected void closeSession(){
		session.getTransaction().commit();
		session.close();
	}
	
}
