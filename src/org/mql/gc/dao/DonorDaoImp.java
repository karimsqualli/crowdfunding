package org.mql.gc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mql.gc.models.Donation;
import org.mql.gc.models.Donor;

public class DonorDaoImp implements DonorDao {
	private BaseDAO dao;
	
	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	public DonorDaoImp() {
		dao = BaseDAO.getINSTANCE();
	}

	public void create(Donor donor) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(donor);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			dao.closeSession(session);
		}
	}

	public void update(int id) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Donor donor = (Donor)session.get(Donor.class, id);
			session.update(donor);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			dao.closeSession(session);
		}
	}

	public void delete(int id) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Donor donor = (Donor)session.get(Donor.class, id);
			session.delete(donor);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			dao.closeSession(session);
		}
	}

	public List<Donor> select() {
		Session session = dao.getSession();
		session.beginTransaction();
		Query<Donor> query = session.createQuery("from Donor", Donor.class); 
		List<Donor> list = query.list(); 
		session.getTransaction().commit();
		dao.closeSession(session);
		return list;
	}

	public Donor selectById(int id) {
		Session session = dao.getSession();
		session.beginTransaction();
		Donor donor = (Donor)session.get(Donor.class, id);
		session.getTransaction().commit();
		dao.closeSession(session);
		return donor;
	}

	public List<Donor> selectByName(String name) {
		Session session = dao.getSession();
		session.beginTransaction();
		String s = "FROM Donor E WHERE E.name = :name";
		Query<Donor> query = session.createQuery(s, Donor.class);
		List<Donor> list = query.list();
		session.getTransaction().commit();
		dao.closeSession(session);
		return list;
	}

	public boolean login(String email, String password) {
		Session session = dao.getSession();
		session.beginTransaction();
		String s = "FROM Donor E WHERE E.email = :email and E.password = :password and E.keyActive = :keyActiva";
		Query<Donor> query = session.createQuery(s, Donor.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		query.setParameter("keyActiva", "active");
		List<Donor> list = query.list();
		session.getTransaction().commit();
		dao.closeSession(session);
		
		if (list.size() > 0) return true;
		else return false;
	}

	public Donor selectByEmail(String email) {
		Session session = dao.getSession();
		session.beginTransaction();
		String s = "FROM Donor E WHERE E.email = :email";
		Query<Donor> query = session.createQuery(s, Donor.class);
		query.setParameter("email", email);
		Donor donor = (Donor)query.uniqueResult();
		session.getTransaction().commit();
		dao.closeSession(session);
		return donor;
	}

	public Donor findByActiveKey(String key) {
		Session session = dao.getSession();
		session.beginTransaction();
		String hql = "FROM Donor E WHERE E.keyActive = :keyActive";
		Query<Donor> query = (Query<Donor>) session.createQuery(hql);
		query.setParameter("keyActive", key);
		Donor don = (Donor) query.uniqueResult();
		session.getTransaction().commit();
		dao.closeSession(session);
		return don;
	}
	
	public Donor select(String email , String key) {
		Session session = dao.getSession();
		session.beginTransaction();
		String hql = "FROM Donor E WHERE E.keyActive = :keyActive and E.email= :Emaila";
		Query<Donor> query = (Query<Donor>) session.createQuery(hql);
		query.setParameter("keyActive", key);
		query.setParameter("Emaila", email);
		Donor don = (Donor) query.uniqueResult();
		session.getTransaction().commit();
		dao.closeSession(session);
		return don;
	}
	
	public void activeAccount(String email , String key) {
		Session session = dao.getSession();
		session.beginTransaction();
		String hql = "FROM Donor E WHERE E.keyActive = :keyActive and E.email= :Emaila";
		Query<Donor> query = (Query<Donor>) session.createQuery(hql);
		query.setParameter("keyActive", key);
		query.setParameter("Emaila", email);
		Donor don = (Donor) query.uniqueResult();
		don.setKeyActive("active");
		session.getTransaction().commit();
		dao.closeSession(session);
	}
	
}