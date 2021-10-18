package fr.doranco.eboutique.model.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.eboutique.entity.Commande;

public interface ICommandeDao {

	List<Commande> getCommande() throws SQLException;
	Commande getCommandeById(Integer id) throws SQLException;
	Commande getCommandeByUtilisateur(Integer idUtilisateure) throws Exception;
	Commande addCommande(Commande commande, Integer idUtilisateur) throws Exception;
	void updateCommande(Commande commande) throws Exception;
	void removeCommande(Integer id) throws Exception;
		
}