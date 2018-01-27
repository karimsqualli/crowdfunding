package org.mql.gc.dao;

import java.util.List;

import org.mql.gc.models.Case;

public interface CaseDao {
	public void create(Case caseObject);
	public List<Case> select();
	public List<Case> selectUrgent();
	public List<Case> select(String title, String category) ;
	public List<Case> select(int id);
	public List<Case> findPending();
}