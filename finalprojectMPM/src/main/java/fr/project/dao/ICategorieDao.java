package fr.project.dao;

import java.sql.SQLException;
import java.util.List;

import fr.project.entity.Categorie;

public interface ICategorieDao {

	List<Categorie> getCategorie() throws SQLException;
	Categorie getCategorieById(Integer id) throws SQLException;
	Categorie addCategorie(Categorie categorie) throws Exception;
}
