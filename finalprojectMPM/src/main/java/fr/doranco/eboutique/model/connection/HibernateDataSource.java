package fr.doranco.eboutique.model.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public final class HibernateDataSource {

	private static HibernateDataSource instance;
	private SessionFactory sessionFactory;
	private Session session;
	
	private HibernateDataSource() {
		
		//Hibernate 3 et 4
//		Configuration config = new Configuration().configure();
//		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
//		registry.applySettings(config.getProperties());
//		ServiceRegistry serviceRegistry = registry.build();
//		sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		//Hibernate 5 et >
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static HibernateDataSource getSession() {
		
		if (instance == null) {
			instance = new HibernateDataSource();
		}
		
		return instance;
	}
	
}
