package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connectiondb.connectionDb;
import model.CarModelBean;


public class CarModelDao {

	private Connection con;

	public boolean createCarModel(CarModelBean carModelBean) {

		try {
			con = connectionDb.getConnection();
			String sql = "INSERT INTO car_models (car_model_name, id_car_brands_fk) VALUES (?, ?)";
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, carModelBean.getName());
			ps.setInt(2, carModelBean.getBrandBean().getId());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectionDb.closeConnection();
		}
		return false;

	}

	public List<CarModelBean> searchModelForName(String name) {
		try {
			con = connectionDb.getConnection();
			List<CarModelBean> newList = new ArrayList<>();
			String sql = "select id_car_models, car_model_name, id_car_brands, car_brand_name FROM car_models JOIN car_brands ON id_car_brands = id_car_brands_fk;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				CarModelBean carModelBean = new CarModelBean();
				carModelBean.setId(result.getInt("id_car_models"));
				carModelBean.setName(result.getString("car_model_name"));
				carModelBean.getBrandBean().setId(result.getInt("id_car_brands"));
				carModelBean.getBrandBean().setName(result.getString("car_brand_name"));
				newList.add(carModelBean);
			}
			return newList;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectionDb.closeConnection();
		}
		return null;
	}

	public List<CarModelBean> listOfModels() {
		try {
			con = connectionDb.getConnection();
			List<CarModelBean> newList = new ArrayList<>();
			String sql = "select id_car_models, car_model_name, id_car_brands, car_brand_name FROM car_models JOIN car_brands ON id_car_brands = id_car_brands_fk;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				CarModelBean carModelBean = new CarModelBean();
				carModelBean.setId(result.getInt("id_car_models"));
				carModelBean.setName(result.getString("car_model_name"));
				carModelBean.getBrandBean().setId(result.getInt("id_car_brands"));
				carModelBean.getBrandBean().setName(result.getString("car_brand_name"));
				newList.add(carModelBean);
			}
			return newList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectionDb.closeConnection();
		}
		return null;
	}

	public boolean editCarModel(CarModelBean carModelBean) {

		try {
			con = connectionDb.getConnection();
			String sql = "UPDATE car_models SET car_model_name =?, id_car_brands_fk=? WHERE id_car_models=?";
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, carModelBean.getName());
			ps.setInt(2, carModelBean.getBrandBean().getId());
			ps.setInt(3, carModelBean.getId());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectionDb.closeConnection();
		}
		return false;

	}

	public boolean deleteModel(CarModelBean carModelBean) {

		try {
			con = connectionDb.getConnection();
			String sql = "DELETE FROM car_models WHERE id_car_models=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, carModelBean.getId());
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectionDb.closeConnection();
		}

		return false;
	}
}