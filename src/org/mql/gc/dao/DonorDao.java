package org.mql.gc.dao;

import java.util.List;

import org.mql.gc.models.Donation;
import org.mql.gc.models.Donor;

public interface DonorDao {
	public void create(Donor donor) ;
	public void update(int id) ;
	public void delete(int id) ;
	public List<Donor> select();
	public Donor selectById(int id) ;
	public List<Donor> selectByName(String name);
	public boolean login(String email, String password);
	public Donor selectByEmail(String email);
	public Donor select(String email,String key);
}