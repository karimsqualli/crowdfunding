package association.dao;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class BaseDAO {
	
	protected Session session=null ; 
	private String source="D:/JEE WORKSPACE/association2/src/Hibernate.cfg.xml";
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
