package fr.project.connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceConnexion {

	public DataSourceConnexion() {
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/projet_final_db?useSSL=false&serverTimezone=UTC";
		String user = "projetdb";
		String password = "1234";
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, user, password);
	}

}
