package fr.doranco.eboutique.model.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.eboutique.entity.Categorie;

public interface ICategorieDao {

	List<Categorie> getCategorie() throws SQLException;
	Categorie getCategorieById(Integer id) throws SQLException;
	Categorie addCategorie(Categorie categorie) throws Exception;
}
