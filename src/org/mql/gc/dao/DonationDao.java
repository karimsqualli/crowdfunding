package org.mql.gc.dao;

import org.mql.gc.models.Donation;

public interface DonationDao {
	public void create(Donation donation);
	public double selectCost(int id);
}
