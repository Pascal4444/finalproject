package fr.doranco.eboutique.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.model.connection.HibernateConnector;

public class UserDao implements IUserDao {

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User addUser(User user) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(user);
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
		return user;
	}

	@Override
	public void updateUser(User user) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.update(user);
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
	public void deleteUser(Integer id) throws Exception {

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
	public User getUserById(Integer id) throws Exception{
		Session session = HibernateConnector.getSession();
		return session.find(User.class, id);
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		Session session = HibernateConnector.getSession();
		Query<User> query = session.createQuery("FROM User u WHERE u.email =: email", User.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

	@Override
	public List<User> getUserByVille(String ville) throws Exception {
		
		Session session = HibernateConnector.getSession();
		Query<User> query = session.createQuery("FROM User u WHERE u.adresses.ville =: ville", User.class);
		query.setParameter("ville", ville);
		return query.list();
	}
	

}


/* Exemple
	public List<User> getUserByVille(String ville) throws Exception {
		
		Session session = HibernateConnector.getSession();
		Query<User> query = session.createQuery("FROM User u WHERE u.adresses.ville =: ville", User.class);
		query.setParameter("ville", ville);
		return query.list();
	}
*/