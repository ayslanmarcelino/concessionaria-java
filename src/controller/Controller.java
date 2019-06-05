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

	private UserDao userDao = new UserDao();
	private EmployeeDao employeeDao = new EmployeeDao();

	
	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

	public String authUser() {
		return userDao.authUser(user);
	}

	// USER
	public void cadUser() {
		userDao.cadUser(user);
	}

	// EMPOLYEE
	public void cadEmployee() {
		employeeDao.cadEmployee(employee);
	}

}
