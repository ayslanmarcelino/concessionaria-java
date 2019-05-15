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
    	System.out.println("Entrou LOGIN");
    	String redirect = null;
        
    	try {       	 
        	con = connectionDb.getConnection();
			
			String sql = "select * from users where name = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(sql); 
             ps.setString(1, userBean.getEmail());
             ps.setString(2, userBean.getPassword());
             ResultSet rs = ps.executeQuery();
             
             if (rs.next()) {
            	 redirect = "cadastrar_usuario";	            	 
             }else {
            	 redirect = "index";
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
