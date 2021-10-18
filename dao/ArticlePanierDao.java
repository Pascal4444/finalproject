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

public class ArticlePanierDao implements IArticlePanierDao {

	private Connection connexion = null;
	
	public ArticlePanierDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArticlePanier getArticlePanierById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(User.class, id);
	}

	@Override
	public void addUtilisateur(ArticlePanier articlePanier) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(articlePanier);
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
	
	public List<ArticlePanier> getUtilisateurById(Integer id) throws Exception {
	
		Session session = HibernateConnector.getSession();
		Query<ArticlePanier> query = session.createQuery("FROM ArticlePanier u WHERE u.commande.id =: id", ArticlePanier.class);
		query.setParameter("id", id);
		return query.list();
	}

}
