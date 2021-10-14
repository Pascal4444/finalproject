package fr.doranco.pf_cryptage.main;

import java.sql.Connection;
import fr.doranco.pf_cryptage.dao.CryptageDataSource;



public class DecryptageApp {
	
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
	}


}
