package fr.doranco.eboutique.model.dao;

import java.util.List;

import fr.doranco.eboutique.entity.User;

public interface IUserDao {

	User getUtilisateurById(Integer id) throws Exception;
	void addUtilisateur(User utilisateurs) throws Exception;
	List<User> getUtilisateursByVille(String ville) throws Exception;
}
