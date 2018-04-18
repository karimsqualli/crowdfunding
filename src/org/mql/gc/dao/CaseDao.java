package org.mql.gc.dao;

import java.util.Date;
import java.util.List;
import org.mql.gc.models.Case;

public interface CaseDao {
	public void create(Case caseObject);
	public List<Case> select();
	public List<Case> selectUrgent();
	public List<Case> select(String title, String category) ;
	public List<Case> select(int id);
	public List<Case> select(String city);
	public List<Case> getCases(String key,String category, String association, String ville, String title, Date date,double cost);
	public List<Case> findPending();
	public void deleteCase(int id);
	public void update(Case caseObject);
}