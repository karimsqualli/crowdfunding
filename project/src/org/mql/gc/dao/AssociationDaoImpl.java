package org.mql.gc.dao;



import java.util.List;

import org.mql.gc.models.Association;


public class AssociationDaoImpl extends BaseDAO implements AssociationDao {
	


	public AssociationDaoImpl() {
		super();
	}
	
	public void add(Association a) {
		System.out.println("appelle de dao");
		super.startSession();
		session.save(a);
		super.closeSession();
	}


	public Association edite(Association e) {
		super.startSession();
		Association p=(Association)session.merge(e);
		super.closeSession();
		return p;
	}

	public void delete(Long id) {
		Association Association=this.findById(id);
		super.startSession();
		session.delete(Association);
		super.closeSession();
	}


	public List<Association> findAll() {
		super.startSession();
		List liste=session.createQuery("from Association").list() ; 
		super.closeSession();
		return liste;
	}

	
	public Association findById(Long id) {
		super.startSession();
		Association p=(Association)session.get(Association.class, id);
		super.closeSession();
		return p;
	}

}
