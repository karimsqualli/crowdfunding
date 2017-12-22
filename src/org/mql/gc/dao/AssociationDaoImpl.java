package org.mql.gc.dao;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mql.gc.models.Association;

public class AssociationDaoImpl implements AssociationDao {
	private BaseDAO dao;

	public AssociationDaoImpl() {
		dao = BaseDAO.getInstance();
	}

	public void create(Association a) {
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

	public Association update(Association e) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Association p = (Association) session.merge(e);
			
			tx.commit();
			
			return p;
			
		} catch (RuntimeException e1) {
			if (tx != null)
				tx.rollback();
			throw e1;
		} finally {
			dao.closeSession(session);
		}
	}

	public void delete(Long id) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		
			Association association = findById(id);
			System.out.println(association.getName());
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

	public List<Association> findAll() {
		Session session = dao.getSession();

		Query query = session.createQuery("from Association");
		List liste = query.list();
		dao.closeSession(session);

		return liste;
	}

	public Association findById(Long id) {
		Session session = dao.getSession();
		Association p = (Association) session.get(Association.class, id);
		dao.closeSession(session);

		return p;
	}

	public Association findByEmail(String email) {
		Session session = dao.getSession();

		String hql = "FROM Association E WHERE E.email = :email";
		Query<Association> query = session.createQuery(hql);
		query.setParameter("email", email);
		Association ass = (Association) query.uniqueResult();

		dao.closeSession(session);

		return ass;
	}

	public Association findByName(String name) {
		Session session = dao.getSession();

		String hql = "FROM Association E WHERE E.name = :name";
		Query<Association> query = (Query<Association>) session.createQuery(hql);
		query.setParameter("name", name);
		Association ass = (Association) query.uniqueResult();

		dao.closeSession(session);

		return ass;
	}

	public boolean loginAssociation(String em, String password) {

		Session session = dao.getSession();

		String s = "from Association where email='" + em + "' and password='" + password + "'";
		Query query = session.createQuery(s);
		List list = query.list();

		dao.closeSession(session);

		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}

	}
}
