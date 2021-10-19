package fr.doranco.eboutique.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.eboutique.entity.Article;
import fr.doranco.eboutique.entity.Commande;
import fr.doranco.eboutique.entity.LigneDeCommande;
import fr.doranco.eboutique.model.connection.HibernateConnector;

public class LigneDeCommandeDao implements ILigneDeCommandeDao {

	public LigneDeCommandeDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addLigneDeCommande(LigneDeCommande ldc) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(ldc);
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
	public void updateLigneDeCommande(LigneDeCommande ldc) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.update(ldc);
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
	public void deleteLigneDeCommande(Integer id) throws Exception {

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
	public LigneDeCommande getLigneDeCommandeById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(LigneDeCommande.class, id);
	}

	@Override
	public Commande getCommandeByLigneDeCommande(Integer commande_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getArticleByLigneDeCommande(Integer article_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
