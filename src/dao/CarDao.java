package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectiondb.connectionDb;
import model.CarBean;
import model.CarModelBean;

public class CarDao {
	
	private Connection con;

	public void CreateCar(CarBean carBean) {
		
		try {
			con = connectionDb.getConnection();
			String sql = "INSERT INTO cars (manufacturing_year, chassi, fuel_type, description, price, quantity, status, id_car_brands_fk, id_car_models_fk) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, carBean.getManufacturing_year());
			ps.setString(2, carBean.getChassi());
			ps.setString(3, carBean.getFuel());
			ps.setString(4, carBean.getDescription());
			ps.setDouble(5, carBean.getPrice());
			ps.setInt(6, carBean.getQuantity());
			ps.setString(7, carBean.getStatus());
			ps.setInt(8, carBean.getCarBrandBean().getId());
			ps.setInt(9, carBean.getCarModelBean().getId());

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectionDb.closeConnection();
		}


	}
	
	public List<CarBean> searchForCarDescription (String description){
		
		try {
			con = connectionDb.getConnection();
			List<CarBean> newList = new ArrayList<>();
			String sql = "SELECT a.id_cars, a.manufacturing_year, a.chassi, a.fuel_type, a.description, a.price,\r\n" + 
					"a.id_car_brands_fk, a.id_car_models_fk, a.quantity, a.status,\r\n" + 
					"b.id_car_models, b.car_model_name,\r\n" + 
					"c.id_car_brands, c.car_brand_name \r\n" + 
					"FROM cars a\r\n" + 
					"INNER JOIN car_models b ON a.id_car_models_fk = b.id_car_models\r\n" + 
					"INNER JOIN car_brands c ON a.id_car_brands_fk = c.id_car_brands";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  "%" + description + "%");
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				CarBean carBean = new CarBean();
				carBean.setId(result.getInt(""));
				carBean.setChassi(result.getString("chassi"));
				carBean.setDescription(result.getString("description"));
				carBean.setFuel(result.getString("fuel_type"));
				carBean.setManufacturing_year(result.getInt("manufacturing_year"));
				carBean.setPrice(result.getDouble("price"));
				carBean.setQuantity(result.getInt("quantity"));
				carBean.setStatus(result.getString("status"));
				carBean.getCarBrandBean().setId(result.getInt("id_car_brands"));
				carBean.getCarBrandBean().setName(result.getString("car_brand_name"));
				carBean.getCarModelBean().setId(result.getInt("id_car_models"));
				carBean.getCarModelBean().setName(result.getString("car_model_name"));
				newList.add(carBean);
			}
			return newList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectionDb.closeConnection();
		}
		
		
		return null;
		
		
	}
	
	public List<CarBean> listOfCars(){
		try {
			con = connectionDb.getConnection();
			List<CarBean> newList = new ArrayList<>();
			String sql = "SELECT a.id_cars, a.manufacturing_year, a.chassi, a.fuel_type, a.description, a.price,\r\n" + 
					"a.id_car_brands_fk, a.id_car_models_fk, a.quantity, a.status,\r\n" + 
					"b.id_car_models, b.car_model_name,\r\n" + 
					"c.id_car_brands, c.car_brand_name \r\n" + 
					"FROM cars a\r\n" + 
					"INNER JOIN car_models b ON a.id_car_models_fk = b.id_car_models\r\n" + 
					"INNER JOIN car_brands c ON a.id_car_brands_fk = c.id_car_brands";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				CarBean carBean = new CarBean();
				carBean.setId(result.getInt("id_cars"));
				carBean.setChassi(result.getString("chassi"));
				carBean.setDescription(result.getString("description"));
				carBean.setFuel(result.getString("fuel_type"));
				carBean.setManufacturing_year(result.getInt("manufacturing_year"));
				carBean.setPrice(result.getDouble("price"));
				carBean.setQuantity(result.getInt("quantity"));
				carBean.setStatus(result.getString("status"));
				carBean.getCarBrandBean().setId(result.getInt("id_car_brands"));
				carBean.getCarBrandBean().setName(result.getString("car_brand_name"));
				carBean.getCarModelBean().setId(result.getInt("id_car_models"));
				carBean.getCarModelBean().setName(result.getString("car_model_name"));
				newList.add(carBean);
			}
			return newList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectionDb.closeConnection();
		}
		
		
		return null;
	}
	
	public void EditCar(CarBean carBean) {

		try {
				con = connectionDb.getConnection();
				String sql = "UPDATE cars SET manufacturing_year=?, id_car_brands_fk=?, id_car_models_fk=? WHERE id_cars=?";
				//String sql = "UPDATE cars SET manufacturing_year=?, chassi=?, fuel_type=?, description=?, price=?, quantity=?, status=?, id_car_brands_fk=?, id_car_models_fk=? WHERE id_cars=?";
				System.out.println(sql);
				PreparedStatement ps = con.prepareStatement(sql);

				/*
				ps.setInt(1, carBean.getManufacturing_year());
				ps.setString(2, carBean.getChassi());
				ps.setString(3, carBean.getFuel());
				ps.setString(4, carBean.getDescription());
				ps.setDouble(5, carBean.getPrice());
				ps.setInt(6, carBean.getQuantity());
				ps.setString(7, carBean.getStatus());
				ps.setInt(8, carBean.getCarBrandBean().getId());
				ps.setInt(9, carBean.getCarModelBean().getId());;
				ps.executeUpdate();
				 */
				
				ps.setInt(1, carBean.getManufacturing_year());
				ps.setInt(2, carBean.getCarBrandBean().getId());
				ps.setInt(3, carBean.getCarModelBean().getId());
				ps.setInt(4, carBean.getId());
				ps.executeUpdate();


			} catch (SQLException e) {

				e.printStackTrace();

			} finally {

				connectionDb.closeConnection();
			}

		
		
		
	}
	
	public void DeleteCar (CarBean carBean) {
		
	}
}
