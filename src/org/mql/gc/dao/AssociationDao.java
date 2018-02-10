package org.mql.gc.dao;

import java.util.List;

import org.mql.gc.models.Association;
import org.mql.gc.models.Donor;

public interface AssociationDao {
	public void create(Association association);
	public void update(Association association);
	public void delete(int id);
	public List<Association> select();
	public Association selectById(int id);
	public Association selectByName(String name);
	public boolean login(String email,String password);
	public Association selectByEmail(String email);
	public List<Association> selectNotActivated(); 
	public boolean isActivated(String email);
	public Association select(String email,String key);
	public void active(String email,String key);
}
