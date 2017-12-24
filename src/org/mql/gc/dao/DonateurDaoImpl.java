package org.mql.gc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.NamedQuery;
import org.mql.gc.models.Association;
import org.mql.gc.models.Donation;
import org.mql.gc.models.Donnateur;

public class DonateurDaoImpl implements DonateurDao {
	private BaseDAO dao;

	public DonateurDaoImpl() {
		dao = BaseDAO.getInstance();
	}

	public void create(Donnateur a) {
		
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(a);

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			dao.closeSession(session);
		}
	}

	public Donnateur update(Donnateur a) {
		
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(a);

			tx.commit();
			
			return a;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			dao.closeSession(session);
		}
	}

	public void delete(Long id) {

		Session session = dao.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			Donnateur donnateur = new Donnateur();
			donnateur.setId(id);

			session.delete(donnateur);

			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			dao.closeSession(session);
		}
	}

	public List<Donnateur> findAll() {
		Session session = dao.getSession();
		session.beginTransaction();

		List liste = session.createQuery("from Donnateur").list();
		session.getTransaction().commit();

		dao.closeSession(session);
		return liste;
	}

	public Donnateur findById(Long id) {
		Session session = dao.getSession();
		session.beginTransaction();
		Donnateur p = (Donnateur) session.get(Donnateur.class, id);
		session.getTransaction().commit();
		dao.closeSession(session);
		return p;
	}

	@SuppressWarnings("unchecked")
	public Donnateur findByName(String name) {
		System.out.println("find by name function ");
		Session session = dao.getSession();
		session.beginTransaction();

		String hql = "FROM Donnateur E WHERE E.name = :name";
		Query<Donnateur> query = (Query<Donnateur>) session.createQuery(hql);
		query.setParameter("name", name);
		Donnateur ass = (Donnateur) query.uniqueResult();
		session.getTransaction().commit();

		dao.closeSession(session);

		return ass;
	}

	@SuppressWarnings("unchecked")
	public Donnateur loginDonator(String email, String password) {
		Session session = dao.getSession();
		session.beginTransaction();

		String hql = "FROM Donnateur E WHERE E.email = :email and E.password = :password";
		Query<Donnateur> query = (Query<Donnateur>) session.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);

		Donnateur don = (Donnateur) query.uniqueResult();
		session.getTransaction().commit();

		dao.closeSession(session);

		return don;
	}

	@SuppressWarnings("unchecked")
	public Donnateur findByEmail(String email) {
		Session session = dao.getSession();
		session.beginTransaction();

		String hql = "FROM Donnateur E WHERE E.email = :email";
		Query<Donnateur> query = (Query<Donnateur>) session.createQuery(hql);
		query.setParameter("email", email);

		Donnateur don = (Donnateur) query.uniqueResult();
		session.getTransaction().commit();

		dao.closeSession(session);

		return don;
	}

	@SuppressWarnings("unchecked")
	public Donnateur findByPassword(String password) {
		Session session = dao.getSession();
		session.beginTransaction();

		String hql = "FROM Donnateur E WHERE E.password = :password";
		Query<Donnateur> query = (Query<Donnateur>) session.createQuery(hql);

		Donnateur don = (Donnateur) query.uniqueResult();
		session.getTransaction().commit();

		dao.closeSession(session);

		return don;
	}
	/*
	 * TODO: function duplique, a supprimer(remplacer par create)
	 * @see org.mql.gc.dao.DonateurDao#saveDonn(org.mql.gc.models.Donation)
	 */
	public void saveDonn(Donation donn) {
		Session session = dao.getSession();
		session.beginTransaction();
		session.save(donn);
		session.getTransaction().commit();
		dao.closeSession(session);
	}

}
