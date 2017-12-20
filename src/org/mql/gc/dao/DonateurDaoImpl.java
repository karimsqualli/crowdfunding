package org.mql.gc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.annotations.NamedQuery;
import org.mql.gc.models.Association;
import org.mql.gc.models.Donation;
import org.mql.gc.models.Donnateur;

public class DonateurDaoImpl implements DonateurDao {
	private BaseDAO dao;

	public DonateurDaoImpl() {
		dao = new BaseDAO();
	}

	public void add(Donnateur a) {
		System.out.println("appelle de dao");
		dao.openSession();
		dao.getSession().beginTransaction();
		dao.getSession().save(a);
		dao.getSession().getTransaction().commit();
		dao.closeSession();
	}

	public Donnateur edite(Donnateur e) {
		dao.openSession();
		dao.getSession().beginTransaction();

		Donnateur p = (Donnateur) dao.getSession().merge(e);
		dao.getSession().getTransaction().commit();

		dao.closeSession();
		return p;
	}

	public void delete(Long id) {
		Donnateur Donnateur = this.findById(id);
		dao.openSession();
		dao.getSession().beginTransaction();

		dao.getSession().delete(Donnateur);
		dao.getSession().getTransaction().commit();

		dao.closeSession();
	}

	public List<Donnateur> findAll() {
		dao.openSession();
		dao.getSession().beginTransaction();

		List liste = dao.getSession().createQuery("from Donnateur").list();
		dao.getSession().getTransaction().commit();

		dao.closeSession();
		return liste;
	}

	public Donnateur findById(Long id) {
		dao.openSession();
		dao.getSession().beginTransaction();
		Donnateur p = (Donnateur) dao.getSession().get(Donnateur.class, id);
		dao.getSession().getTransaction().commit();
		dao.closeSession();
		return p;
	}

	@SuppressWarnings("unchecked")
	public Donnateur findByName(String name) {
		System.out.println("find by name function ");
		dao.openSession();
		dao.getSession().beginTransaction();

		String hql = "FROM Donnateur E WHERE E.name = :name";
		Query<Donnateur> query = (Query<Donnateur>) dao.getSession().createQuery(hql);
		query.setParameter("name", name);
		Donnateur ass = (Donnateur) query.uniqueResult();
		dao.getSession().getTransaction().commit();

		dao.closeSession();

		return ass;
	}

	@SuppressWarnings("unchecked")
	public Donnateur loginDonator(String email, String password) {
		dao.openSession();
		dao.getSession().beginTransaction();

		System.out.println("email => " + email + "passsword => " + password);
		String hql = "FROM Donnateur E WHERE E.email = :email and E.password = :password";
		Query<Donnateur> query = (Query<Donnateur>) dao.getSession().createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);

		Donnateur don = (Donnateur) query.uniqueResult();
		dao.getSession().getTransaction().commit();

		dao.closeSession();

		return don;
	}

	@SuppressWarnings("unchecked")
	public Donnateur findByEmail(String email) {
		System.out.println("find by email function ");
		System.out.println(email);

		dao.openSession();
		dao.getSession().beginTransaction();

		String hql = "FROM Donnateur E WHERE E.email = :email";
		Query<Donnateur> query = (Query<Donnateur>) dao.getSession().createQuery(hql);
		query.setParameter("email", email);

		Donnateur don = (Donnateur) query.uniqueResult();
		dao.getSession().getTransaction().commit();

		dao.closeSession();

		return don;
	}

	@SuppressWarnings("unchecked")
	public Donnateur findByPassword(String password) {
		System.out.println("find by name function ");
		dao.openSession();
		dao.getSession().beginTransaction();

		String hql = "FROM Donnateur E WHERE E.password = :password";
		Query<Donnateur> query = (Query<Donnateur>) dao.getSession().createQuery(hql);

		Donnateur don = (Donnateur) query.uniqueResult();
		dao.getSession().getTransaction().commit();

		dao.closeSession();

		return don;
	}
	
	public void saveDonn(Donation donn) {
		dao.openSession();
		dao.getSession().beginTransaction();
		dao.getSession().save(donn);
		dao.getSession().getTransaction().commit();
		dao.closeSession();
	}

}
