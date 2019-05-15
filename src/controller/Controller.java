package controller;

import javax.faces.bean.ManagedBean;

import dao.BrandDao;
import dao.CarModelDao;
import dao.UserDao;
import model.BrandBean;
import model.CarModelBean;
import model.UserBean;

@ManagedBean
public class Controller {

	private UserBean user = new UserBean();
	private BrandBean brand = new BrandBean();
	private CarModelBean carModel = new CarModelBean();
	
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
	
	public void cadBrand() {
		BrandDao brandDao = new BrandDao();
		brandDao.cadBrand(brand);
	}
	
	public void cadCarModel() {
		CarModelDao carModelDao = new CarModelDao();
		carModelDao.cadCarModel(carModel);
	}
	
}
