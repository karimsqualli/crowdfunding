package org.mql.gc.dao;

import java.util.List;

import org.mql.gc.models.Donation;
import org.mql.gc.models.Donnateur;

public interface DonateurDao {
	public void create(Donnateur a) ;
	public Donnateur update(Donnateur e) ;
	public void delete(int id) ;
	
	public List<Donnateur> findAll() ;
	public Donnateur findById(int id) ;
	public Donnateur findByName(String name);
	public Donnateur loginDonator(String email, String password);
	public Donnateur findByEmail(String email);
	public Donnateur findByPassword(String password);
	public void saveDonn(Donation donn);
	public Donnateur findBykeyAndEmail(String email,String key);
}
