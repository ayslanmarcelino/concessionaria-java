package model;

public class CarBean {

	private int id;
	private int manufacturing_year;
	private String chassi;
	private String description;
	private Double price;
	private CarBrandBean carBrandBean = new CarBrandBean();
	private CarModelBean carModelBean = new CarModelBean();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getManufacturing_year() {
		return manufacturing_year;
	}
	public void setManufacturing_year(int manufacturing_year) {
		this.manufacturing_year = manufacturing_year;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public CarBrandBean getCarBrandBean() {
		return carBrandBean;
	}
	public void setCarBrandBean(CarBrandBean carBrandBean) {
		this.carBrandBean = carBrandBean;
	}
	public CarModelBean getCarModelBean() {
		return carModelBean;
	}
	public void setCarModelBean(CarModelBean carModelBean) {
		this.carModelBean = carModelBean;
	}
	

	
}

