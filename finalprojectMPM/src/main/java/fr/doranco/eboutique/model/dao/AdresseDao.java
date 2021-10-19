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
	public Adresse getAdresseByIdss(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(Adresse.class, id);
	}
	
	public List<Adresse> getUtilisateursByVilless(String ville) throws Exception {
	
		Session session = HibernateConnector.getSession();
		Query<Adresse> query = session.createQuery("FROM Adresse u WHERE u.adresses.ville =: ville", Adresse.class);
		query.setParameter("ville", ville);
		return query.list();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAdresse(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Adresse getAdresseById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse getAdresseByUtilisateur(Integer idUtilisateur) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

