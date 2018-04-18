package org.mql.gc.dao;

import java.util.Date;
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
		System.out.println(select());
	}

	public void create(Case caseObject) {
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
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
		Query<Case> query = session.createQuery("from Case WHERE pending='1'",Case.class);
		list = query.list();
		dao.closeSession(session);
		return list;		
}
	
	public List<Case> selectUrgent() {
			Session session = dao.getSession();
			Query<Case> query = session.createQuery("from Case WHERE pending='1' order by cost asc, endDate asc", Case.class);
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

	public List<Case> select(String city) {
		Session session = dao.getSession();
		Query<Case> query = session.createQuery("from Case WHERE city ='" + city + "'", Case.class);
		List<Case> list = query.list();
		dao.closeSession(session);			
		return list;
	}

	public List<Case> getCases(String key,String category, String association, String ville, String title, Date date,double cost) {
		String HQLStatement = "From Case c where c.pending="+true;//here the pending should added
		if(category != null )
			HQLStatement+=" and c.category like '%"+category+"%'"; 
		if(association !=  null) {
			AssociationDao associationDao=new AssociationDaoImp(); 
			int idAsso = associationDao.selectByName(association).getId();
			HQLStatement+=" and c.idAssociation="+idAsso; 
		}
		if(key!=null && !key.equals("") && !key.isEmpty()) {
			HQLStatement+=" and c.title like '%"+key+"%' OR c.slogan like '"+key+"'"; 
		}
		if (ville != null) 
			HQLStatement+=" and c.city like '%"+ville+"%'";
		if(title!=null)
			HQLStatement+=" and c.title="+title;
		if(date!=null)
			HQLStatement+=" and c.endDate="+date;
		if(cost != 0)
			HQLStatement+=" and c.cost="+cost;
		System.out.println(HQLStatement);
		List<Case> liste = null;		
		Session session = dao.getSession();
		Query<Case> query = session.createQuery(HQLStatement,Case.class);
		liste = query.list();
		dao.closeSession(session);			
		return liste;
	}
	
	
	
}
