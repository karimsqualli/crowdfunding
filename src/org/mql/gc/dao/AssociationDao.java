package org.mql.gc.dao;

import java.util.List;

import org.mql.gc.models.Association;

public interface AssociationDao {
	
	public void create(Association a) ;
	public Association update(Association e) ;
	public void delete(Long id) ;
	
	public List<Association> findAll() ;
	public Association findById(Long id) ;
	public Association findByName(String name);
	public boolean loginAssociation(String email,String password);
	Association findByEmail(String email);
}
