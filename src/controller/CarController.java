package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.CarDao;
import model.CarBean;
import model.CarBrandBean;
import model.CarModelBean;

@ManagedBean
public class CarController {

	private CarBean carBean = new CarBean();
	private CarDao carDao = new CarDao();
	private List<CarBean> carBeanList;
	private String searchField;
	private CarModelBean carModelBean = new CarModelBean();
	private CarBrandBean carBrandBean = new CarBrandBean();
	
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
	
	public List<CarBean> getCarBeanList() {
		if (this.carBeanList == null) {
			this.carBeanList = carDao.listOfCars();
		}
		return this.carBeanList;
	}
	public void setCarBeanList(List<CarBean> carBeanList) {
		this.carBeanList = carBeanList;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	public CarModelBean getCarModelBean() {
		return carModelBean;
	}
	public void setCarModelBean(CarModelBean carModelBean) {
		this.carModelBean = carModelBean;
	}
	public CarBrandBean getCarBrandBean() {
		return carBrandBean;
	}
	public void setCarBrandBean(CarBrandBean carBrandBean) {
		this.carBrandBean = carBrandBean;
	}
	
	//Methods
	

	public void createCar() {
		carDao.CreateCar(carBean);
	}
	
	public void searchByDescri() {
		this.carBeanList = carDao.searchForCarDescription(searchField);

	}
	
	public void editCar() {
		carDao.EditCar(carBean);
	}




}
