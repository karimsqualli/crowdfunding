package org.mql.gc.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mql.gc.models.Admin;

public class AdminDaoImp implements AdminDao{
	private BaseDAO dao;
	
	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	public AdminDaoImp() {
		dao = BaseDAO.getINSTANCE();
	}
	
	public boolean login(String email, String password) {
		System.out.println("ddddddd");
		Session session = dao.getSession();
		String s = "from Admin where email='" + email + "' and password='" + password + "' ";
		Query<Admin> query = session.createQuery(s, Admin.class);
		List<Admin> list = query.list();
		dao.closeSession(session);
		
		if (list.size() > 0) return true;
		else return false;
	}
}
