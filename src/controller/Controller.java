package controller;

import javax.faces.bean.ManagedBean;

import dao.UserDao;
import model.UserBean;

@ManagedBean
public class Controller {

	private UserBean user = new UserBean();

	
	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
	public void cadUser() {
		UserDao userDao = new UserDao();
		userDao.cadUser(user);
	}
	
	public String authUser() {
		UserDao userDao = new UserDao();
		return userDao.authUser(user);
	}
	
}
