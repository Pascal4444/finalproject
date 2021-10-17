package fr.project.dao;

import java.sql.SQLException;
import java.util.List;

import fr.project.entity.Utilisateur;

public interface IUtilisateurDao {

	List<User> getUtilisateur() throws SQLException;
	User getUtilisateurById(Integer id) throws SQLException;
	User addUtilisateur(User utilisateurs) throws Exception;
	User getUserByEmail(String email) throws Exception;
}
