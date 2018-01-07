/*
 * Modifie Par Karim le 22/11/17
 */

package org.mql.gc.dao;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.identity.SybaseAnywhereIdentityColumnSupport;


/*
 * 
 * Cette classe est la classe de base pour acceder a la base de donner
 * Cette classe utilise le pattern singleton [ https://fr.wikipedia.org/wiki/Singleton_(patron_de_conception)] ]
 * pour initializer une seule fois la `session_factory` qui est un objet lours et prend beacoup de temp a cree
 * 
 * 
 * -- Utilisation --
 * 
 * `BaseDao.getInstance()` au lieu de new `New BaseDao()`
 * 
 * `Session s = dao.getSession()` pour recuperer une nouvelle session
 * `closeSession(s)` pour fermer la session 
 */
public class BaseDAO {
	private static BaseDAO INSTANCE = new BaseDAO();
	private SessionFactory session_factory;
	
	private BaseDAO() {
		Configuration config = new Configuration();
		session_factory = config.configure().buildSessionFactory();
	}
	
	
	
	public static BaseDAO getINSTANCE() {
		return INSTANCE;
	}



	public static void setINSTANCE(BaseDAO iNSTANCE) {
		INSTANCE = iNSTANCE;
	}




	
	public Session getSession() {
		return session_factory.openSession();
	}

	public void closeSession(Session session) {
		session.close();
	}
	
}
