package config;
import java.sql.*;

public class connection {
	public static  Connection getDBConnection() throws ClassNotFoundException, SQLException{
		 Connection con=null;
		//String url="jdbc:sqlserver://STUDIO03;database=pcs";com.microsoft
		 
		String url="jdbc:sqlserver://localhost:1433;instanceName=EXPRESSEDITION;database=pcs";
		
		String username="sa";
		String password="anzla@123";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 con=(Connection)DriverManager.getConnection(url,username,password);
		return con;
}

	public static Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}
}