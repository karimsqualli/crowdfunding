package org.mql.gc.services;

import java.util.List;

import org.mql.gc.dao.AssociationDAO;
import org.mql.gc.dao.AssociationDAOImpl;
import org.mql.gc.models.Association;

public class AssociationServiceImpl implements AssociationService {

	private AssociationDAO dao=(AssociationDAO) new AssociationDAOImpl();
	
	public void add(Association e) {
		System.out.println("appelle de service");
		dao.add(e);
	}

	
	public Association edite(Association e) {
		return dao.edite(e);
	}

	
	public void delete(Long id) {
		dao.delete(id);
	}

	
	public List<Association> findAll() {
		return dao.findAll();
	}
	
	public Association findById(Long id) {
		return dao.findById(id);
	}
}
