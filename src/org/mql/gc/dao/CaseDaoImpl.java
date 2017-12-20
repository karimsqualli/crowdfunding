
package org.mql.gc.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.mql.gc.models.Cas;

public class CaseDaoImpl implements CaseDao {
	private BaseDAO dao;

	public CaseDaoImpl() {
		dao = new BaseDAO();
	}
	// ha dao li mat2akad mna shiha 100% okay

	@Override
	public void insererCas(Cas cas) {
		System.out.println(cas);
		System.out.println("DAO AVANT OUVERTURE SESSION");
		dao.openSession();// session tathal
		System.out.println("Open");
		dao.getSession().beginTransaction();// transaction
		dao.getSession().save(cas);// ha lmohim
		System.out.println("Save");
		dao.getSession().getTransaction().commit();// ha l commit
		System.out.println("APRES transaction");
		dao.closeSession();// hanta bash t2akad ila hadashi khadam
	}

	@Override
	public List<Cas> afficherListcas() {
		// Cas cas= new Cas();
		List<Cas> liste = new ArrayList<Cas>();
		try {
			System.out.println("dao afficher liste de cas");
			dao.openSession();
			Query query = dao.getSession().createQuery("from Cas");
			liste = query.list();
			dao.closeSession();

		} catch (Exception e) {
			System.out.println("ne recupere pas les cas::" + e.getMessage());
		}
		return liste;
	}
	
	
	public List<Cas> afficherListcas(String nom, String category) {
		// Cas cas= new Cas();
		List<Cas> liste = new ArrayList<Cas>();
		try {
			System.out.println("dao afficher liste de cas");
			dao.openSession();
			// dao.getSession().beginTransaction();
			
			
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
			System.out.println("test case dao");
			System.out.println(squery);

			Query query = dao.getSession().createQuery(squery);
			liste = query.list();
			// dao.getSession().getTransaction().commit();
			dao.closeSession();

		} catch (Exception e) {
			System.out.println("ne recupere pas les cas::" + e.getMessage());
		}
		return liste;

	}
	
	public double calc(int id) {
		dao.openSession();
		dao.getSession().beginTransaction();
		//Cas cas = session.load(Cas.class, id);
		String s = "select sum(cout) from Donation where idCas='" + id +"'";
		Double res = (Double)dao.getSession().createQuery(s).uniqueResult();
		System.out.println("rs :"+res);
		//session.refresh(cas);
		dao.getSession().getTransaction().commit();
		dao.closeSession();
		if(res==null) {
				res=(double) 0;
				}
		return res;
	}
	
	
	


}
