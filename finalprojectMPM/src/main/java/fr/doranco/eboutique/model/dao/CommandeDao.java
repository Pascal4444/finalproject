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

public class CommandeDao implements ICommandeDao {

	private Connection connexion = null;
	
	public CommandeDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Commande getCommandeById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(Commande.class, id);
	}

	@Override
	public void addUtilisateur(Commande commande) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(commande);
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
	
	public List<Commande> getUtilisateursByVille(String ville) throws Exception {
	
		Session session = HibernateConnector.getSession();
		Query<Commande> query = session.createQuery("FROM Commande u WHERE u.adresses.ville =: ville", Commande.class);
		query.setParameter("ville", ville);
		return query.list();
	}

}
