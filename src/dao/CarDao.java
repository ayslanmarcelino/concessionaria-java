package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import connectiondb.connectionDb;
import model.CarBean;

public class CarDao {
	
	private Connection con;

	public void CreateCar(CarBean carBean) {
		
		try {
			con = connectionDb.getConnection();
			String sql = "INSERT INTO cars manufacturing_year, chassi, fuel_type, description, price, id_car_brands_fk, id_car_models_fk) VALUES (?, ?, ?, ?, ?, ?, ?);";
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, carBean.getManufacturing_year());
			ps.setString(2, carBean.getChassi());
			ps.setString(3, carBean.getFuel());
			ps.setString(4, carBean.getDescription());
			ps.setDouble(5, carBean.getPrice());
			ps.setInt(6, carBean.getCarBrandBean().getId());
			ps.setInt(7, carBean.getCarModelBean().getId());

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectionDb.closeConnection();
		}


	}
	
	public List<CarBean> searchForCarName (String name){
		return null;
	}
	
	public List<CarBean> listOfCars(){
		return null;
	}
	
	public void EditCar(CarBean carBean) {
		
	}
	
	public void DeleteCar (CarBean carBean) {
		
	}
}
