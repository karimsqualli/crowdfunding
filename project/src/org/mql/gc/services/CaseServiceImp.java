package org.mql.gc.services;

import org.mql.gc.dao.CaseDao;
import org.mql.gc.dao.CaseDaoImp;
import org.mql.gc.models.Case;

public class CaseServiceImp implements CaseService {
	private CaseDao caseDao;
	
	public CaseServiceImp() {
		caseDao = new CaseDaoImp();
	}

	public void save(Case caseObject) {
		caseDao.saveCase(caseObject);
	}
	
}
