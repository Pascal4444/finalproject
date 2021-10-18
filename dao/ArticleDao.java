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

public class ArticleDao implements IArticleDao {

	private Connection connexion = null;
	
	public ArticleDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Article getArticleById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(Article.class, id);
	}

	@Override
	public void addUtilisateur(Article article) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(article);
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
	
	public List<Article> getUtilisateursByNom(String nom) throws Exception {
	
		Session session = HibernateConnector.getSession();
		Query<Article> query = session.createQuery("FROM Article u WHERE u.description.nom =: nom", Article.class);
		query.setParameter("nom", nom);
		return query.list();
	}

}
