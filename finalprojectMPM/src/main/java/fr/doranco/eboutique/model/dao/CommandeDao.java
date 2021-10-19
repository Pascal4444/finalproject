package fr.doranco.eboutique.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.doranco.eboutique.entity.Adresse;
import fr.doranco.eboutique.entity.CartePaiement;
import fr.doranco.eboutique.entity.Commande;
import fr.doranco.eboutique.entity.LigneDeCommande;
import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.model.connection.HibernateConnector;

public class CommandeDao implements ICommandeDao {

	public CommandeDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCommande(Commande commande) throws Exception {

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

	@Override
	public void updateCommande(Commande commande) throws Exception {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getSession();
			session.update(commande);
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
	public void deleteCommande(Integer id) throws Exception {

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
	public Commande getCommandeById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		return session.find(Commande.class, id);
	}

	@Override
	public CartePaiement getCartePaiementByCommande(Integer carte_paiement) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse getAdresseFacturationByCommande(Integer adresse_facturation) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse getAdresseLivraisonByCommande(Integer adresse_livraison) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByCommande(Integer user_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LigneDeCommande> getLigneDeCommandeByCommande(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
