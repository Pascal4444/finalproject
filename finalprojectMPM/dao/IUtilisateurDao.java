package fr.doranco.eboutique.model.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.eboutique.entity.Utilisateur;

public interface IUtilisateurDao {

	List<Utilisateur> getUtilisateur() throws SQLException;
	Utilisateur getUtilisateurById(Integer id) throws SQLException;
	Utilisateur addUtilisateur(Utilisateur utilisateurs) throws Exception;
	Utilisateur getUserByEmail(String email) throws Exception;
}
