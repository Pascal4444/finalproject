package fr.doranco.eboutique.model.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateConnector {

	private static HibernateConnector instance;
	private static SessionFactory sessionFactory;
	private static Session session;
	
	private HibernateConnector() {
		
		//Hibernate 3 et 4
//		Configuration config = new Configuration().configure();
//		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
//		registry.applySettings(config.getProperties());
//		ServiceRegistry serviceRegistry = registry.build();
//		sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		//Hibernate 5 et >
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession() {
		
		if (instance == null) {
			instance = new HibernateConnector();
		}
		if (session == null || session.isOpen()) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
}
