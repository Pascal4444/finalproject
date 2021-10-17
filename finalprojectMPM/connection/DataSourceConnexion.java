package fr.doranco.eboutique.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceConnexion {

	public DataSourceConnexion() {
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/projet_final_db?useSSL=false&serverTimezone=UTC";
		String user = "projetdb";
		String password = "1234";
		return DriverManager.getConnection(url, user, password);
	}

}
