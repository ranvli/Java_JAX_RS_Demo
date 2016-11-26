package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
	
	static String connectionString =  
            "jdbc:sqlserver://IDEV01\\MSSQLSERVER14:1433;"  
            + "database=Davivienda;"  
            + "user=sa;"  
            + "password=Pa$$w0rd;" ;
	
	 static Connection connection = null;  
     
     
     public static Connection Conectar()
     {
    	 
    	 
    	 try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			connection = DriverManager.getConnection(connectionString);  
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    	 
    	 
    	return connection;
         
         
     }
     

}
