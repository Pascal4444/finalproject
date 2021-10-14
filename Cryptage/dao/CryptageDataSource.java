package fr.doranco.pf_cryptage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CryptageDataSource {

	public CryptageDataSource() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/security_db";
		String user = "root";
		String password = "root";
			
		return DriverManager.getConnection(url, user, password);
		
		
		
	}
}
