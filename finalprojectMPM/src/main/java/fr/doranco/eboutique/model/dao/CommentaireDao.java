package fr.doranco.eboutique.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.doranco.eboutique.entity.Commentaire;
import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.model.connection.HibernateConnector;

public class CommentaireDao implements ICommentaireDao {

	public CommentaireDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCommentaire(Commentaire comment) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.save(comment);
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
	public void updateCommentaire(Commentaire comment) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.update(comment);
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
	public void deleteCommentaire(Integer id) throws Exception {

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
	public Commentaire getCommentaireById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(Commentaire.class, id);
	}

	@Override
	public Commentaire getArticleByCommentaire(Integer article_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByCommentaire(Integer user_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
