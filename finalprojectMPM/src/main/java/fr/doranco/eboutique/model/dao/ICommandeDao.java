package fr.doranco.eboutique.model.dao;

import java.util.List;

import fr.doranco.eboutique.entity.Adresse;
import fr.doranco.eboutique.entity.CartePaiement;
import fr.doranco.eboutique.entity.Commande;
import fr.doranco.eboutique.entity.User;

public interface ICommandeDao {
	void addCommande(Commande commande) throws Exception;
	void updateCommande(Commande commande) throws Exception;
	void deleteCommande(Integer id) throws Exception;
	Commande getCommandeById(Integer id) throws Exception ;
	// @OneToMany _ @OneToOne _ @ManyToOne
	CartePaiement getCartePaiementByCommande(Integer carte_paiement) throws Exception;
	Adresse getAdresseFacturationByCommande(Integer adresse_facturation) throws Exception;
	Adresse getAdresseLivraisonByCommande(Integer adresse_livraison) throws Exception;
	User getUserByCommande(Integer user_id) throws Exception;
	List<LigneDeCommande> getLigneDeCommandeByCommande(Integer id) throws Exception;
}


