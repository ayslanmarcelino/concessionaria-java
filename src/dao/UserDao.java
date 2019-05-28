package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connectiondb.connectionDb;
import model.UserBean;


public class UserDao {
	
	private Connection con;
	
	public String authUser(UserBean userBean) {  

    	String redirect = null;
        
    	try {       	 
        	con = connectionDb.getConnection();
			
			String sql = "SELECT * FROM email WHERE email = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(sql); 
             ps.setString(1, userBean.getEmail());
             ps.setString(2, userBean.getPassword());
             ResultSet rs = ps.executeQuery();
             
             if (rs.next()) {
            	 redirect = "home";	            	 
             }else {
            	 redirect = "login_falhou";
             }	             	             
            
		} catch (Exception e) {
			e.printStackTrace();
		}
      
        finally {
        	connectionDb.closeConnection();	        	
        }        

        return redirect;
    }
	
	public int cadUser(UserBean user) {
		
		int idUser = 0;
		
		try {
			con = connectionDb.getConnection();
					
			String sql = "INSERT INTO users (name,email,password) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			

			idUser = ps.executeUpdate(); 
			System.out.println(idUser);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionDb.closeConnection();
		}
			return idUser;
		
	}
	
	 
	
}
