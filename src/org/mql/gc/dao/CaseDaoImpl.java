
package org.mql.gc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mql.gc.models.Cas;

public class CaseDaoImpl implements CaseDao {
	private BaseDAO dao;

	public CaseDaoImpl() {
		dao = BaseDAO.getInstance();
	}

	@Override
	public void create(Cas cas) {
		
		
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(cas);

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			dao.closeSession(session);
		}
	}

	@Override
	public List<Cas> findAll() {

		List<Cas> liste = new ArrayList<Cas>();
		try {
			Session session = dao.getSession();
			Query query = session.createQuery("from Cas");
			liste = query.list();
			dao.closeSession(session);
			
			return liste;

		} catch (Exception e) {
			System.out.println("ne recupere pas les cas::" + e.getMessage());
			throw e;
		}
		
	}
	
	
	public List<Cas> findByTitleAndCategory(String nom, String category) {
		List<Cas> liste = new ArrayList<Cas>();
		try {
			Session session = dao.getSession();
			
			// building query
			String squery = "from Cas C";
			
			if(( nom != null && nom.length() > 0) || (category != null && category.length() > 0)) {
				squery += " where ";
				
				if(nom.length() > 0 ) {
					squery += " titre LIKE '%" + nom +"%'";
					squery += " AND ";
				}
				
				if(category.length() > 0 ) {
					squery += " categorie = '" + category + "'";
				}
				
			}

			Query query = session.createQuery(squery);
			liste = query.list();
			dao.closeSession(session);
			
			return liste;

		} catch (Exception e) {
			System.out.println("ne recupere pas les cas::" + e.getMessage());
			throw e;
		}
	
	}
	
	//ELMORABET Hicham (sprint 2 -- 15/12/2017)
	//La liste des cas supportés par un donateur ( donné par son id )
	public double calc(int id) {
	public double getDonatorCasCount(int id) {
		Session session = dao.getSession();
		session.beginTransaction();
		String s = "select sum(cout) from Donation where idCas='" + id +"'";
		Double res = (Double)session.createQuery(s).uniqueResult();
		session.getTransaction().commit();
		dao.closeSession(session);
		if(res == null) {
			res=(double) 0;
		}
		return res;
	}

	//ELMORABET Hicham (sprint 3 -- 22/12/2017)
	//La liste des cas supportés par un donateur ( donné par son id )
	public List<Cas> getAllCases(int idDonor) {
	//ELMORABET Hicham (sprint 3 -- 22/10/2017)
	//La liste des cas supportes par un donateur ( donne par son id )
	public List<Cas> findByIdDonor(int idDonor) {
		Session session = dao.getSession();
		String s = "from Cas as cs where cs.id in (select don.idCas from Donation as don where don.idUser='" + idDonor + "')";
		Query<Cas> query = session.createQuery(s, Cas.class);
		List<Cas> list = query.list();
		dao.closeSession(session);
		return list;
	}
	
	
	


}
