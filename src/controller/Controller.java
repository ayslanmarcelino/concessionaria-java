package controller;

import javax.faces.bean.ManagedBean;

import dao.EmployeeDao;
import dao.UserDao;
import model.EmployeeBean;
import model.UserBean;

@ManagedBean
public class Controller {

	private UserBean user = new UserBean();
	private EmployeeBean employee = new EmployeeBean();

	
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
	
	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

	public void cadEmployee() {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.cadEmployee(employee);
	}
	
}
