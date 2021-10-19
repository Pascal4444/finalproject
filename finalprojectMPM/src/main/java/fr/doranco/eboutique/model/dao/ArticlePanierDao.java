package fr.doranco.eboutique.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.doranco.eboutique.entity.Article;
import fr.doranco.eboutique.entity.ArticlePanier;
import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.model.connection.HibernateConnector;

public class ArticlePanierDao implements IArticlePanierDao {

	public ArticlePanierDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addArticlePanier(ArticlePanier articlepanier) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(articlepanier);
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
	public void updateArticlePanier(ArticlePanier articlepanier) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.update(articlepanier);
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
	public void deleteArticlePanier(Integer id) throws Exception {

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
	public ArticlePanier getArticlePanierById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(ArticlePanier.class, id);
	}

	@Override
	public Article getArticleByArticlePanier(Integer article_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByArticlePanier(Integer user_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
