package org.mql.gc.dao;

import java.util.List;

import org.mql.gc.models.Donation;
import org.mql.gc.models.Donnateur;

public interface DonateurDao {
	public void add(Donnateur a) ;
	public Donnateur edite(Donnateur e) ;
	public void delete(Long id) ;
	public List<Donnateur> findAll() ;
	public Donnateur findById(Long id) ;
	public Donnateur findByName(String name);
	public Donnateur loginDonator(String email, String password);
	public Donnateur findByEmail(String email);
	public void saveDonn(Donation donn);

}
