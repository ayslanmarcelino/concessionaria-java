package controller;

import javax.faces.bean.ManagedBean;

import dao.CarBrandDao;
import model.CarBrandBean;


@ManagedBean
public class CarBrandController {

	private CarBrandBean carBrand = new CarBrandBean();
	
	public CarBrandBean getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrandBean carBrand) {
		this.carBrand = carBrand;
	}

	public void createBrand() {
		CarBrandDao carBrandDao = new CarBrandDao();
		carBrandDao.createCarBrand(carBrand);
	}
	
}
