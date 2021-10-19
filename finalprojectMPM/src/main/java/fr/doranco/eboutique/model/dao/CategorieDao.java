package fr.doranco.eboutique.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.doranco.eboutique.entity.Article;
import fr.doranco.eboutique.entity.Categorie;
import fr.doranco.eboutique.model.connection.HibernateConnector;

public class CategorieDao implements ICategorieDao {

	public CategorieDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCategorie(Categorie cate) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(cate);
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
	public void updateCategorie(Categorie cate) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.update(cate);
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
	public void deleteCategorie(Integer id) throws Exception {

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
	public Categorie getCategorieById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(Categorie.class, id);
	}

	@Override
	public List<Article> getArticleByCategorie(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
