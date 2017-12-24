package org.mql.gc.dao;

import java.util.List;

import org.mql.gc.models.Cas;
import org.mql.gc.models.Donation;

public interface CaseDao {
	public void insererCas(Cas cas);
	public List<Cas> afficherListcas();
	public List<Cas> afficherListcas(String nom, String category) ;
	public List<Cas> getAllCases(int idDonor);
	public double calc(int id);
	
}