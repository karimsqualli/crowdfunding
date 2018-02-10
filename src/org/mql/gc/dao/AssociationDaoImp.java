package org.mql.gc.dao;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mql.gc.models.Association;
import org.mql.gc.models.Donor;

public class AssociationDaoImp implements AssociationDao {
	private BaseDAO dao;
	
	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	public AssociationDaoImp() {
		dao = BaseDAO.getINSTANCE();
	}

	public void create(Association association) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(association);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			dao.closeSession(session);
		}
	}

	public void update(Association association) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(association);
			tx.commit();
		} catch (RuntimeException e1) {
			if (tx != null)
				tx.rollback();
			throw e1;
		} finally {
			dao.closeSession(session);
		}
	}

	public void delete(int id) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Association association = session.get(Association.class, id);
			session.delete(association);
			tx.commit();
		} catch (RuntimeException e1) {
			if (tx != null)
				tx.rollback();
			throw e1; 
		} finally {
			dao.closeSession(session);
		}
	}

	public List<Association> select() {
		Session session = dao.getSession();
		Query<Association> query = session.createQuery("from Association where pending = 'true'", Association.class);
		List<Association> list = query.list();
		dao.closeSession(session);
		return list;
	}
	
	public List<Association> selectNotActivated() {
		Session session = dao.getSession();
		Query<Association> query = session.createQuery("from Association where pending='0'", Association.class);
		List<Association> list = query.list();
		dao.closeSession(session);
		System.out.println("here");
		for (Association association : list) {
			System.out.println(association);
		}
		return list;
	}

	public Association selectById(int id) {
		Session session = dao.getSession();
		Association association = (Association) session.get(Association.class, id);
		dao.closeSession(session);
		return association;
	}

	public Association selectByEmail(String email) {
		Session session = dao.getSession();
		String s = "FROM Association E WHERE E.email = :email";
		Query<?> query = session.createQuery(s);
		query.setParameter("email", email);
		Association association = (Association)query.uniqueResult();
		dao.closeSession(session);
		return association;
	}

	public Association selectByName(String name) {
		Session session = dao.getSession();
		String s = "FROM Association E WHERE E.name = :name";
		Query<?> query = session.createQuery(s);
		query.setParameter("name", name);
		Association association = (Association)query.uniqueResult();
		dao.closeSession(session);
		return association;
	}

	public boolean login(String email, String password) {
		Session session = dao.getSession();
		String s = "FROM Association E WHERE E.email = :email and E.password = :password";
		Query<Association> query = session.createQuery(s, Association.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<Association> list = query.list();
		dao.closeSession(session);
		
		if (list.size() > 0) return true;
		else return false;
	}
	
	public boolean isActivated(String email){
		Session session = dao.getSession();
		String s = "FROM Association E WHERE E.email = :email and E.keyActive = :keyActiva";
		Query<Association> query = session.createQuery(s, Association.class);
		query.setParameter("email", email);
		query.setParameter("keyActiva", "active");
		List<Association> list = query.list();
		dao.closeSession(session);
		if (list.size() > 0) return true;
		else return false;	
	}

	public Association select(String email, String key) {
		Session session = dao.getSession();
		String s = "FROM Association E WHERE E.email = :email and E.keyActive = :KeyActiva";
		Query<?> query = session.createQuery(s);
		query.setParameter("email", email);
		query.setParameter("KeyActiva", key);

		Association association = (Association)query.uniqueResult();
		dao.closeSession(session);
		return association;
	}

	public void active(String email, String key) {
		Session session = dao.getSession();
		session.beginTransaction();
		String hql = "FROM Association E WHERE E.keyActive = :keyActive and E.email= :Emaila";
		Query<Association> query = (Query<Association>) session.createQuery(hql);
		query.setParameter("keyActive", key);
		query.setParameter("Emaila", email);
		Association don = (Association) query.uniqueResult();
		don.setKeyActive("active");
		session.getTransaction().commit();
		dao.closeSession(session);
	}
	
	
}
