package org.mql.gc.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mql.gc.models.Case;

public class CaseDaoImp implements CaseDao {
	private BaseDAO dao;
	
	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	public CaseDaoImp() {
		dao = BaseDAO.getINSTANCE();
	}

	public void create(Case caseObject) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			caseObject.setPending(true);
			session.save(caseObject);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			dao.closeSession(session);
		}
	}

	public List<Case> select() {
			List<Case> list=null;
			Session session = dao.getSession();
			Query<Case> query = session.createQuery("from Case CS",Case.class);
			list = query.list();
			dao.closeSession(session);
			return list;		
	}
	
	public List<Case> selectUrgent() {
			Session session = dao.getSession();
			Query<Case> query = session.createQuery("from Case C order by cost asc, endDate asc", Case.class);
			List<Case> list = query.list();
			dao.closeSession(session);			
			return list;
	}
	
	public List<Case> select(String title, String category) {
		try {
			Session session = dao.getSession();
			String squery = "from Case C";
			if(( title != null && title.length() > 0) || (category != null && category.length() > 0)) {
				squery += " where ";
				if(title.length() > 0 ) {
					squery += " title LIKE '%" + title +"%'";
					squery += " AND ";
				}
				if(category.length() > 0 ) {
					squery += " category = '" + category + "'";
				}
			}
			Query<Case> query = session.createQuery(squery, Case.class);
			List<Case> list = query.list();
			dao.closeSession(session);
			return list;
		} catch (Exception e) {
			System.out.println("ne recupere pas les cas::" + e.getMessage());
			throw e;
		}
	
	}
	
	public List<Case> select(int id) {
		Session session = dao.getSession();
		String s = "from Case as cs where cs.id in (select don.idCase from Donation as don where don.idUser='" + id + "')";
		Query<Case> query = session.createQuery(s, Case.class);
		List<Case> list = query.list();
		dao.closeSession(session);
		return list;
	}
	
	public void update(Case caseObject) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(caseObject);
			tx.commit();
		} catch (RuntimeException e1) {
			if (tx != null)
				tx.rollback();
			throw e1;
		} finally {
			dao.closeSession(session);
		}
	}

	public void deleteCase(int id) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Case caseObject = session.get(Case.class, id);
			session.delete(caseObject);
			tx.commit();
		} catch (RuntimeException e1) {
			if (tx != null)
				tx.rollback();
			throw e1; 
		} finally {
			dao.closeSession(session);
		}
	}
	
	public List<Case> findPending() {
		List<Case> liste = null;		
			Session session = dao.getSession();
			Query<Case> query = session.createQuery("FROM Case C where C.pending='0'",Case.class);
			liste = query.list();
			dao.closeSession(session);			
		return liste;
	}
	
}
