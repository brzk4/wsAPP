package main_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DB_connector {

	public static Connection conn = null;
	public static void dbConnection() {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			LogIn.lblPoczonoZBaz.setText("Problem z MySQL JDBC Driver");   
			e.printStackTrace();
			return;
		}

		LogIn.lblPoczonoZBaz.setText("MySQL JDBC Driver zarejestrowany");
		
		
		try {
			
			String url = " ";
			String username = " ";
			String password = " ";
			conn = DriverManager.getConnection(url, username, password);
			 
		} catch (SQLException e) {
			LogIn.lblPoczonoZBaz.setText("Brak po³¹czenia z baz¹ danych");
			e.printStackTrace();
			return;
		}
		
		LogIn.lblPoczonoZBaz.setText("Po³¹czono z baz¹ danych");

	}
}
