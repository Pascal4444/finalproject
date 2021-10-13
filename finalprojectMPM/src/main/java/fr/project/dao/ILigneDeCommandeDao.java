package fr.project.dao;

import java.sql.SQLException;
import java.util.List;

import fr.project.entity.LigneDeCommande;

public interface ILigneDeCommandeDao {

	List<LigneDeCommande> getLigneDeCommande() throws SQLException;
	LigneDeCommande getLigneDeCommandeById(Integer id) throws SQLException;
	LigneDeCommande addLigneDeCommande(LigneDeCommande ligneDeCommande) throws Exception;
}
