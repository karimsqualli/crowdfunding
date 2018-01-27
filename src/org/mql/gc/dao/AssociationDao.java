package org.mql.gc.dao;

import java.util.List;

import org.mql.gc.models.Association;

public interface AssociationDao {
	public void create(Association association);
	public void update(int id);
	public void delete(int id);
	public List<Association> select();
	public Association selectById(int id);
	public Association selectByName(String name);
	public boolean login(String email,String password);
	public Association selectByEmail(String email);
}
