package org.mql.gc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.mql.gc.models.User;

public class UserDao {
	private BaseDAO dao;

	public UserDao() {
		dao= new BaseDAO();
	}


	public void createUser(User user) {
		dao.openSession();
		dao.getSession().beginTransaction();
		dao.getSession().save(user);
		System.out.println("Save");
		dao.getSession().getTransaction().commit();
		dao.closeSession();
	}

	

	public boolean loginAssociation(String email, String password) {
		dao.openSession();

		/*
		 * List list =
		 * session.createQuery("from User where email=email and password=password").list
		 * ();
		 */
		Query query = dao.getSession().createQuery("from User where email=email and password=password");
		List list = query.list();

		if (list.size() > 0) {
			return true;
		} else {
			dao.closeSession();

			return false;

		}

	}

}
