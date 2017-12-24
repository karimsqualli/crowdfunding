package org.mql.gc.dao;

import java.util.List;

import org.mql.gc.models.Cas;
import org.mql.gc.models.Donation;

public interface CaseDao {
	public void create(Cas cas);
	public List<Cas> findAll();
	public List<Cas> findByTitleAndCategory(String nom, String category) ;
	public List<Cas> findByIdDonor(int idDonor);
	public double getDonatorCasCount(int id);
}