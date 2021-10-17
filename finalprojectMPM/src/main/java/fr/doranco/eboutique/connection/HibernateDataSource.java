package fr.doranco.eboutique.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public final class HibernateDataSource {

	private static HibernateDataSource instance;
	private SessionFactory sessionFactory;
	
	private HibernateDataSource() {
		
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(config.getProperties());
		ServiceRegistry serviceRegistry = registry.build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}
	
	public static HibernateDataSource getInstance() {
		
		if (instance == null) {
			instance = new HibernateDataSource();
		}
		return instance;
	}
	
	public Session getSession() throws Exception {
		
		return sessionFactory.openSession();
		
	}

}
