package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.CarModelDao;
import model.CarBrandBean;
import model.CarModelBean;

@ManagedBean
public class ControllerCarModel {

	private CarModelBean carModel = new CarModelBean();
	private CarModelDao carModelDao = new CarModelDao();
	private CarBrandBean carbrandBean = new CarBrandBean();
	private List<CarModelBean> modelBeanList;
	private String searchField;

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public List<CarModelBean> getModelBeanList() {
		if (this.modelBeanList == null) {
			this.modelBeanList = carModelDao.listOfModels();
		}
		return this.modelBeanList;
	}

	public void setModelBeanList(List<CarModelBean> modelBeanList) {
		this.modelBeanList = modelBeanList;
	}

	public CarModelBean getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModelBean carModel) {
		this.carModel = carModel;
	}

	public CarModelDao getCarModelDao() {
		return carModelDao;
	}

	public void setCarModelDao(CarModelDao carModelDao) {
		this.carModelDao = carModelDao;
	}

	public CarBrandBean getCarbrandBean() {
		return carbrandBean;
	}

	public void setCarbrandBean(CarBrandBean carbrandBean) {
		this.carbrandBean = carbrandBean;
	}

	// METHODS
	
	public void createBrand() {
		carModelDao.createCarModel(carModel);
	}

	public void searchByBrandName() {
		this.modelBeanList = carModelDao.searchModelForName(searchField);

	}

	public void editCarBrand() {
		carModelDao.editCarModel(carModel);
	}

	public void deleteModel() {
		carModelDao.deleteModel(carModel);
	}

}
