package org.mql.gc.dao;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.annotations.NamedQuery;
import org.mql.gc.models.Association;

public class AssociationDaoImpl extends BaseDAO implements AssociationDao {

	public AssociationDaoImpl() {
		super();
	}
	
	public void add(Association a) {
		System.out.println("appelle de dao");
		
		super.openSession();
		session.save(a);
		super.closeSession();
	}


	public Association edite(Association e) {
		super.openSession();
		Association p=(Association)session.merge(e);
		super.closeSession();
		return p;
	}

	public void delete(Long id) {
		Association Association=this.findById(id);
		super.openSession();
		session.delete(Association);
		super.closeSession();
	}


	public List<Association> findAll() {
		super.openSession();
		List liste=session.createQuery("from Association").list() ; 
		super.closeSession();
		return liste;
	}

	
	public Association findById(Long id) {
		super.openSession();
		Association p=(Association)session.get(Association.class, id);
		super.closeSession();
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public Association findByName(String name) {
		System.out.println("find by name function ");
		super.openSession();
		
		String hql = "FROM Association E WHERE E.name = :name";
		Query<Association> query = (Query<Association>) session.createQuery(hql);
		query.setParameter("name", name);
		Association ass = (Association)query.uniqueResult();

		super.closeSession();
		
		return ass;
	}

	@Override
	public boolean loginAssociation(String email, String password) {
		super.openSession();
		Query query = super.session.createQuery("from Association where email=email and password=password");
		List list = query.list();
		super.closeSession();


		if (list.size() > 0) {
			return true;
		} else {

			return false;

		}

	}
	}

