package controller;

import javax.faces.bean.ManagedBean;

import dao.CarBrandDao;
import dao.EmployeeDao;
import dao.UserDao;
import model.CarBrandBean;
import model.EmployeeBean;
import model.UserBean;

@ManagedBean
public class Controller {

	private UserBean user = new UserBean();
	private EmployeeBean employee = new EmployeeBean();
	private CarBrandBean carBrand = new CarBrandBean();
	
	

	public CarBrandBean getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrandBean carBrand) {
		this.carBrand = carBrand;
	}

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
	
	
	
	public void cadUser() {
		UserDao userDao = new UserDao();
		userDao.cadUser(user);
	}
	
	public String authUser() {
		UserDao userDao = new UserDao();
		return userDao.authUser(user);
	}
	
	public void cadEmployee() {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.cadEmployee(employee);
	}
	
	public void createBrand() {
		CarBrandDao carBrandDao = new CarBrandDao();
		carBrandDao.createCarBrand(carBrand);
	}

	


	
}
