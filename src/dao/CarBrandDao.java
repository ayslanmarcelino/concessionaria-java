package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connectiondb.connectionDb;
import model.CarBrandBean;


public class CarBrandDao {

	private Connection con;

	public int createCarBrand(CarBrandBean brand) {
		

		int idBrand = 0;
		
		try {
			con = connectionDb.getConnection();
			String sql = "INSERT INTO car_brands (car_brand_name) VALUES (?)";
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setString(1, brand.getName());
			ps.executeUpdate();

			
		} catch (SQLException e) {

			e.printStackTrace();
			
		} finally {

			connectionDb.closeConnection();
		}
		return idBrand;

}

	
	

}
