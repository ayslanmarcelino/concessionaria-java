package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import dao.CarBrandDao;
import model.CarBrandBean;

@ManagedBean
public class ControllerCarBrand {

	private CarBrandBean carBrand = new CarBrandBean();
	private List<CarBrandBean> brandBeanList;
	private String searchField;
	private CarBrandDao carBrandDao = new CarBrandDao();

	public CarBrandBean getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrandBean carBrand) {
		this.carBrand = carBrand;
	}

	public List<CarBrandBean> getBrandBeanList() {
		if(this.brandBeanList == null) {
			this.brandBeanList = carBrandDao.listOfBrands();
		}
		return this.brandBeanList;
	}

	public void setBrandBeanList(List<CarBrandBean> brandBeanList) {
		this.brandBeanList = brandBeanList;
	}


	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	// Methods Brand
	public void createBrand() {
		carBrandDao.createCarBrand(carBrand);
	}

	public void searchByBrandName() {
		this.brandBeanList = carBrandDao.searchBrandForName(searchField);
		
	}
	
    public void editCarBrand() {
        carBrandDao.editBrands(carBrand);
    }

}
