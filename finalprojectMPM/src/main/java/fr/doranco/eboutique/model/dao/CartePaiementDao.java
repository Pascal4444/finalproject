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

public class CartePaiementDao implements ICartePaiementDao {

	private Connection connexion = null;
	
	public CartePaiementDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CartePaiement getCartePaiementById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(CartePaiement.class, id);
	}

	@Override
	public void addUtilisateur(CartePaiement cartePaiement) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(cartePaiement);
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
	
	public List<CartePaiement> getUtilisateursById(Integer id) throws Exception {
	
		Session session = HibernateConnector.getSession();
		Query<CartePaiement> query = session.createQuery("FROM CartePaiement u WHERE u.numero.id =: id", CartePaiement.class);
		query.setParameter("id", id);
		return query.list();
	}

}
