package fr.project.dao;

import java.sql.SQLException;
import java.util.List;

import fr.project.entity.Utilisateur;

public interface IUtilisateurDao {

	List<Utilisateur> getCours() throws SQLException;
	Utilisateur getCoursById(Integer id) throws SQLException;
	Utilisateur addCours(Utilisateur cours) throws Exception;
}
