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

public class CategorieDao implements ICategorieDao {

	private Connection connexion = null;
	
	public CategorieDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Categorie getCategorieById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(Categorie.class, id);
	}

	@Override
	public void addUtilisateur(Categorie categorie) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(categorie);
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
	
	public List<Categorie> getCategorieByArticle(String article) throws Exception {
	
		Session session = HibernateConnector.getSession();
		Query<Categorie> query = session.createQuery("FROM Categorie u WHERE u.nom.article =: article", Categorie.class);
		query.setParameter("article", article);
		return query.list();
	}

}
