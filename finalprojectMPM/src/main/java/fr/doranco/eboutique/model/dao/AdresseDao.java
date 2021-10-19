package fr.doranco.eboutique.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.eboutique.entity.Adresse;
import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.model.connection.HibernateConnector;

public class AdresseDao implements IAdresseDao {

	
	public AdresseDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addAdresse(Adresse adresse) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(adresse);
			tx = session.beginTransaction();
			tx.commit();
			
		} catch(HibernateException e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updateAdresse(Adresse adresse) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.update(adresse);
			tx = session.beginTransaction();
			tx.commit();
			
		} catch(HibernateException e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}

	@Override
	public void deleteAdresse(Integer id) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.delete(id);
			tx = session.beginTransaction();
			tx.commit();
			
		} catch(HibernateException e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}

	@Override
	public Adresse getAdresseById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(Adresse.class, id);
	}

	@Override
	public User getUserByAdresse(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		Query<User> query = session.createQuery("FROM User u WHERE u.adresse.id =: id", User.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	

}