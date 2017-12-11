package org.mql.gc.services;

import java.util.List;

import org.mql.gc.models.Association;

public interface AssociationService {
	public void add(Association e) ;
	public Association edite(Association e) ;
	public void delete(Long id) ;
	public List<Association> findAll() ;
	public Association findById(Long id) ;
	public boolean nameExist(String name);
}
