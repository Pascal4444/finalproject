package fr.doranco.eboutique.model.dao;

import java.util.List;

import fr.doranco.eboutique.entity.User;

public interface IUserDao {

	User getUtilisateurById(Integer id) throws SQLException;
	List<User> getUtilisateursByVille(String ville) throws SQLException;
	List<User> getUtilisateur() throws SQLException;
	User addUtilisateur(Utilisateur utilisateur) throws Exception;
	void updateUser(Utilisateur utilisateur) throws Exception;
	void removeUser(Integer id) throws Exception;
}