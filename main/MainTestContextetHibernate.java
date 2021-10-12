package fr.doranco.projetFinal.main;

import org.hibernate.Session;

import fr.doranco.projetFinal.model.datasource.HibernateConnector;

public class MainTestContextetHibernate {

	public static void main(String[] args) {

		try {
			Session session = HibernateConnector.getInstance().getSession();
			System.out.println(session);
			if (session != null && session.isOpen()) {
				session.close();
				System.out.println("Contexte Hibernate démarré avec succès");
				System.out.println("Session fermée avec succès");
			} else {
				System.out.println("Impossible de fermer la session !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
