package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectiondb.connectionDb;
import model.EmployeeBean;
import model.UserBean;

public class EmployeeDao {
	
private Connection con;
	
	public int cadEmployee(EmployeeBean employee) {
		
		int idEmployee = 0;
		
		try {
			con = connectionDb.getConnection();
					
			String sql = "INSERT INTO employee (name,email,rg,cpf,date_of_birth,telephone,cellphone,admission_date) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getRg());
			ps.setString(4, employee.getCpf());
			ps.setString(5, employee.getDate_of_birth());
			ps.setString(6, employee.getTelephone());
			ps.setString(7, employee.getCellphone());
			ps.setString(8, employee.getAdmission_date());
			

			idEmployee = ps.executeUpdate(); 
			System.out.println(idEmployee);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionDb.closeConnection();
		}
			return idEmployee;
		
	}
}
