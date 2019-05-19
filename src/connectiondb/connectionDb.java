package connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionDb {
	private static final String driver = "org.postgresql.Driver";
	private static final String url = "jdbc:postgresql://localhost:5432/concessionaria_java";
	private static final String user= "postgres";			
	private static final String password = "post";
	
	// AYSLAN
	//private static final String user= "postgres";			
	//private static final String password = "post";	
	
	private static Connection con = null;
	
	
	public static Connection getConnection() {	
		try {	
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);	
		}catch (Exception e) {	
			throw new RuntimeException("Erro na conex�o: ",e);
		}		
		return con;
	}
	
	public static void closeConnection() {	
		if (con != null) {	
			try {
				con.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}