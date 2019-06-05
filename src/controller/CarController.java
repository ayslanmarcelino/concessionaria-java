package controller;

import dao.CarDao;
import model.CarBean;

public class CarController {

	private CarBean carBean = new CarBean();
	private CarDao carDao = new CarDao();
	public CarBean getCarBean() {
		return carBean;
	}
	public void setCarBean(CarBean carBean) {
		this.carBean = carBean;
	}
	public CarDao getCarDao() {
		return carDao;
	}
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}
	
	
	//Methods
	
	public void createCar() {
		carDao.CreateCar(carBean);
	}
}
