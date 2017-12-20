package org.mql.gc.dao;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.mql.gc.models.Association;

public class AssociationDaoImpl  implements AssociationDao {
	private BaseDAO dao;
	
	public AssociationDaoImpl() {
		dao=new BaseDAO();
	}
	
	public void add(Association a) {
		System.out.println("appelle de dao");
		
		dao.openSession();
		dao.getSession().save(a);
		dao.closeSession();
	}


	public Association edite(Association e) {
		dao.openSession();
		Association p=(Association)dao.getSession().merge(e);
		dao.closeSession();
		return p;
	}

	public void delete(Long id) {
		Association Association=this.findById(id);
		dao.openSession();
		dao.getSession().delete(Association);
		dao.closeSession();
	}


	public List<Association> findAll() {
		System.out.println("recuperation de la liste des associations ");
		dao.openSession();
		Query query = dao.getSession().createQuery("from Association");
		List liste = query.list() ; 
		dao.closeSession();
		return liste;
	}

	
	public Association findById(Long id) {
		dao.openSession();
		Association p=(Association)dao.getSession().get(Association.class, id);
		dao.closeSession();
		return p;
	}
	
	public Association findByEmail(String email) {
		System.out.println("find by name function ");
		dao.openSession();
		
		String hql = "FROM Association E WHERE E.email = :email";
		Query<Association> query = dao.getSession().createQuery(hql);
		query.setParameter("email", email);
		Association ass = (Association)query.uniqueResult();

		dao.closeSession();
		
		return ass;
	}
	
	public Association findByName(String name) {
		System.out.println("find by name function ");
		dao.openSession();
		
		String hql = "FROM Association E WHERE E.name = :name";
		Query<Association> query = (Query<Association>) dao.getSession().createQuery(hql);
		query.setParameter("name", name);
		Association ass = (Association)query.uniqueResult();

		dao.closeSession();
		
		return ass;
	}

	
	public boolean loginAssociation(String em, String password) {

		dao.openSession();	
		String s = "from Association where email='" + em + "' and password='" + password + "'";
		System.out.println(s);
		Query query = dao.getSession().createQuery(s);
		List list = query.list();
		System.out.println(list.size());
		dao.closeSession();


		if (list.size() > 0) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}

	}
	}

