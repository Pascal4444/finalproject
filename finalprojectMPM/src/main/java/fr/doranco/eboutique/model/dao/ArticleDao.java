package fr.doranco.eboutique.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.eboutique.entity.Article;
import fr.doranco.eboutique.entity.Categorie;
import fr.doranco.eboutique.entity.Commentaire;
import fr.doranco.eboutique.model.connection.HibernateConnector;

public class ArticleDao implements IArticleDao {

	public ArticleDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addArticle(Article article) throws Exception {

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

	@Override
	public void updateArticle(Article article) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.update(article);
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
	public void deleteArticle(Integer id) throws Exception {

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
	public Article getArticleById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(Article.class, id);
	}

	@Override
	public Categorie getCategorieByArticle(Integer category_id) throws Exception {
		Session session = HibernateConnector.getSession();
		Query<Categorie> query = session.createQuery("FROM Category c WHERE c.id =: category_id", Categorie.class);
		query.setParameter("category_id", category_id);
		return query.getSingleResult();
	}

	@Override
	public List<Commentaire> getCommentaireByArticle(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}