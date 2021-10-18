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
	public User getUserByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User utilisateur) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(Integer id) throws Exception{
		Session session = HibernateConnector.getSession();
		return session.find(User.class, id);
	}

	public List<User> getUserByVille(String ville) throws Exception {
		
		Session session = HibernateConnector.getSession();
		Query<User> query = session.createQuery("FROM User u WHERE u.adresses.ville =: ville", User.class);
		query.setParameter("ville", ville);
		return query.list();
	}

	@Override
	public void addUser (User user) throws Exception {

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
	}

}
