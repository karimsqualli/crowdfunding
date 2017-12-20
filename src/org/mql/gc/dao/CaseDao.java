package org.mql.gc.dao;

import java.util.List;

import org.mql.gc.models.Cas;
import org.mql.gc.models.Donation;

public interface CaseDao {
	void insererCas(Cas cas);
	List<Cas> afficherListcas();
	List<Cas> afficherListcas(String nom, String category) ;
	public double calc(int id);
}