package dataBase_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import start_package.LogIn;

public class DB_connector {

	public static final DB_connector INSTANCE = new DB_connector();

	public static Connection conn = null;

	private final String url = "***";
	private final String username = "***";
	private final String password = "***";

	/**
	 * MAKE SURE CLASS IS SINGLETON
	 */
	private DB_connector() {
	};

	/**
	 * RETURN INSTANCE OF CLASS DB_connector
	 */
	public static DB_connector getInstance() {
		return INSTANCE;
	}

	/**
	 * RETURN CONNECTION OBJECT, MANDATORY TO USE SQL
	 */
	public Connection ret_connection() {
		return conn;
	}

	public void dbConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			LogIn.lblPoczonoZBaz.setText("Problem z MySQL JDBC Driver");
			e.printStackTrace();
			return;
		}

		LogIn.lblPoczonoZBaz.setText("MySQL JDBC Driver zarejestrowany");

		try {
			conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			LogIn.lblPoczonoZBaz.setText("Brak po³¹czenia z baz¹ danych");
			e.printStackTrace();
			return;
		}

		LogIn.lblPoczonoZBaz.setText("Po³¹czono z baz¹ danych");

	}

 
}
