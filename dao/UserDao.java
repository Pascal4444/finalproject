package fr.doranco.eboutique.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.eboutique.entity.Adresse;
import fr.doranco.eboutique.entity.CartePaiement;
import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.model.connection.HibernateConnector;
import fr.doranco.eboutique.utils.Dates;

public class UserDao implements IUserDao {

	private Connection connexion = null;
	
	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User getUtilisateurById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(User.class, id);
	}

	@Override
	public void addUtilisateur(User user) throws Exception {

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
	
	public List<User> getUtilisateursByVille(String ville) throws Exception {
	
		Session session = HibernateConnector.getSession();
		Query<User> query = session.createQuery("FROM User u WHERE u.adresses.ville =: ville", User.class);
		query.setParameter("ville", ville);
		return query.list();
	}

}