package org.mql.gc.services;

import java.util.List;
import org.mql.gc.models.Association;
import org.mql.gc.models.Cas;
import org.mql.gc.models.Donation;
import org.mql.gc.models.Donnateur;

public interface Service {
	// **********************************Association**********************************
	public void add(Association e);

	public Association edite(Association e);

	public void delete(Long id);

	public List<Association> findAll();

	public Association findById(Long id);

	public boolean nameExist(String name);

	public boolean connectAssociation(String email, String password);

	// ************************************Case**************************************
	public void create(Cas cas);

	public List<Cas> afficherListcas();
	
	public List<Cas> findAllUrgent();

	public List<Cas> afficherListcas(String nom, String category);
	
	public List<Cas> getPendingCases();

	// ************************************Donateur**************************************
	public boolean addDonator(Donnateur e);

	public Donnateur editeDonator(Donnateur e);

	public void deleteDonator(int id);

	public List<Donnateur> findAllDonator();

	public Donnateur findDonatorById(int id);

	public boolean nameDonatorExist(String name);

	public Donnateur connectDonator(String email, String password);

	public boolean emailDonatorExist(String email);

	public boolean passwordDonatorExist(String password);

	public void saveDonn(Donation donn);

	public double calc(int id);
}
