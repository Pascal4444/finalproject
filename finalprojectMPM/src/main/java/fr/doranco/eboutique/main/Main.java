package fr.doranco.eboutique.main;

import org.hibernate.Session;

import fr.doranco.eboutique.model.connection.HibernateConnector;

public class Main {

	public static void main(String[] args) {

		try {
			Session session = HibernateConnector.getSession();
			System.out.println(session);
			System.out.println("Session Hibernate démarrée avec succès !");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
