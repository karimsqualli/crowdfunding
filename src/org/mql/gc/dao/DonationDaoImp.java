package org.mql.gc.dao;

import org.hibernate.Session;
import org.mql.gc.models.Donation;

public class DonationDaoImp implements DonationDao {
	private BaseDAO dao;
	
	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	public DonationDaoImp() {
		dao = BaseDAO.getINSTANCE();
	}

	public void create(Donation donation) {
		Session session = dao.getSession();
		session.beginTransaction();
		session.save(donation);
		session.getTransaction().commit();
		dao.closeSession(session);
	}
	
	public double selectCost(int id) {
		Session session = dao.getSession();
		session.beginTransaction();
		String s = "select sum(cost) from Donation where idCase='" + id +"'";
		Double cost = (Double)session.createQuery(s).uniqueResult();
		session.getTransaction().commit();
		dao.closeSession(session);
		if(cost == null) {
			cost = (double) 0;
		}
		return cost;
	}
		
	

}
