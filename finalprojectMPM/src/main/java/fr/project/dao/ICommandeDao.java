package fr.project.dao;

import java.sql.SQLException;
import java.util.List;

import fr.project.entity.Commande;

public interface ICommandeDao {

	List<Commande> getCommande() throws SQLException;
	Commande getCommandeById(Integer id) throws SQLException;
	Commande addCommande(Commande commande) throws Exception;
}
