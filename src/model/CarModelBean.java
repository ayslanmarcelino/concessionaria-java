package model;

public class CarModelBean {

	private int id;
	private String name;
	private CarBrandBean brandBean = new CarBrandBean(); //A chave estrangeira que quero inserir, no caso
	
	public CarBrandBean getBrandBean() {
		return brandBean;
	}

	public void setBrandBean(CarBrandBean brandBean) {
		this.brandBean = brandBean;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
