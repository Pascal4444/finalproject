package fr.doranco.pf_cryptage.main;

import java.security.Key;
import java.sql.Connection;

import fr.doranco.pf_cryptage.dao.CryptageDataSource;
import fr.doranco.pf_cryptage.dao.IUserDAO;
import fr.doranco.pf_cryptage.dao.UserDAO;



public class MainApp {
	
	public static void main(String[] args) {
		CryptageDataSource datasource = new CryptageDataSource();
		try {
			Connection connection = datasource.getConnection();
			System.out.println("Connexion établie");
			System.out.println(connection);
		} catch (Exception e) {
			System.out.println(e);
		}
          System.exit(0);
	
	
	try {
		
		IUserDAO userDAO = new UserDAO();
		boolean isConnected = userDAO.testEmailPassword("s.y@gmail.com", "Sarah");
		if (isConnected) {
			System.out.println("Connection réussie");
		} else {
			System.out.println("Mot de passe incorrect !");
		}
	 } catch (Exception e) {
		e.printStackTrace();
	 }

  }

}