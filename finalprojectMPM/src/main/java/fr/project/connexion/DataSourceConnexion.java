package fr.project.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceConnexion {

	public DataSourceConnexion() {
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/project_final_db?useSSL=false&serverTimezone=UTC";
		String user = "projectdb";
		String password = "1234";
		return DriverManager.getConnection(url, user, password);
	}

}
