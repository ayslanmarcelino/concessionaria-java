package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import connectiondb.connectionDb;
import model.CarBrandBean;

public class CarBrandDao {

	private Connection con;

	public int createCarBrand(CarBrandBean carBrandBean) {

		int idBrand = 0;

		try {
			con = connectionDb.getConnection();
			String sql = "INSERT INTO car_brands (car_brand_name) VALUES (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, carBrandBean.getName());
			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectionDb.closeConnection();
		}
		return idBrand;

	}

	public List<CarBrandBean> searchBrandForName(String name) {

		try {
			con = connectionDb.getConnection();
			List<CarBrandBean> newList = new ArrayList<>();

			String sql = "SELECT * FROM car_brands WHERE car_brand_name LIKE ? ORDER BY 1 ASC;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				CarBrandBean carBrandBean = new CarBrandBean();
				carBrandBean.setId(result.getInt("id_car_brands"));
				carBrandBean.setName(result.getString("car_brand_name"));
				newList.add(carBrandBean);
			}
			return newList;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectionDb.closeConnection();
		}
		return null;

	}

	public List<CarBrandBean> listOfBrands() {

		try {
			con = connectionDb.getConnection();
			List<CarBrandBean> newList = new ArrayList<>();

			String sql = "SELECT * FROM car_brands ORDER BY car_brand_name";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				CarBrandBean carBrandBean = new CarBrandBean();
				carBrandBean.setId(result.getInt("id_car_brands"));
				carBrandBean.setName(result.getString("car_brand_name"));
				newList.add(carBrandBean);
			}
			return newList;
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectionDb.closeConnection();
		}
		return null;

	}

	public boolean editBrands(CarBrandBean carBrandBean) {
		try {
			con = connectionDb.getConnection();
			String sql = "UPDATE car_brands SET car_brand_name =? WHERE id_car_brands=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, carBrandBean.getName());
			ps.setInt(2, carBrandBean.getId());
			
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectionDb.closeConnection();
		}
		return false;
	}

	public boolean deleteBrand(CarBrandBean carBrandBean) {
		try {
			con = connectionDb.getConnection();
			String sql = "DELETE FROM car_brands WHERE id_car_brands=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, carBrandBean.getId());
			ps.execute();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			connectionDb.closeConnection();
		}
		return false;
	}

}
