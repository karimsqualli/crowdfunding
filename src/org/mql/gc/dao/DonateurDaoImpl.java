package org.mql.gc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.annotations.NamedQuery;
import org.mql.gc.models.Association;
import org.mql.gc.models.Donation;
import org.mql.gc.models.Donnateur;

public class DonateurDaoImpl implements DonateurDao {
	private BaseDAO dao;

	public DonateurDaoImpl() {
		dao = dao.getInstance();
	}

	public void add(Donnateur a) {
		Session session = dao.getSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		dao.closeSession(session);
	}

	public Donnateur edite(Donnateur e) {
		Session session = dao.getSession();
		session.beginTransaction();

		Donnateur p = (Donnateur) session.merge(e);
		session.getTransaction().commit();

		dao.closeSession(session);
		return p;
	}

	public void delete(Long id) {
		Donnateur Donnateur = this.findById(id);
		Session session = dao.getSession();
		session.beginTransaction();

		session.delete(Donnateur);
		session.getTransaction().commit();

		dao.closeSession(session);
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
	
	public void saveDonn(Donation donn) {
		Session session = dao.getSession();
		session.beginTransaction();
		session.save(donn);
		session.getTransaction().commit();
		dao.closeSession(session);
	}

}
