package org.mql.gc.services;

import java.util.Vector;

import org.mql.gc.dao.UserDao;
import org.mql.gc.models.User;

public class UserDaoService {
	private UserDao userDao;
	private Vector<User> list;

	public UserDaoService() {
		userDao = new UserDao();
		list = new Vector<>();
		list.add(new User(10, "HICHAM", "HICHAM", "HICHAM"));
		list.add(new User(20, "HASSAN", "HASSAN", "HASSAN"));
	}

	public UserDaoService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public void create(User user) {
		System.out.println("service");
		userDao.createUser(user);
	}

	public boolean validate(User utilisateur) {
		for (User u : list) {
			if (utilisateur.getEmail().equals(u.getEmail()) && utilisateur.getPassword().equals(u.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean connectUser(String email, String password) {
		return userDao.loginAssociation(email, password);
	}

}
