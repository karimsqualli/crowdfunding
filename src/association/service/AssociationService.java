package association.service;

import java.util.List;

import association.dao.AssociationDAO;
import association.model.Association;

public class AssociationService {

	private AssociationDAO dao=new AssociationDAO();
	
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
