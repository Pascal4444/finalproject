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

public class AdresseDao implements IAdresseDao {

	private Connection connexion = null;
	
	public AdresseDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Adresse getAdresseById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(Adresse.class, id);
	}

	@Override
	public void addUtilisateur(Adresse adresse) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(Adresse);
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
	
	public List<Adresse> getUtilisateursByVille(String ville) throws Exception {
	
		Session session = HibernateConnector.getSession();
		Query<Adresse> query = session.createQuery("FROM Adresse u WHERE u.adresses.ville =: ville", Adresse.class);
		query.setParameter("ville", ville);
		return query.list();
	}

}

