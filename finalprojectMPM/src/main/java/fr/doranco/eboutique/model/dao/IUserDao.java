package fr.doranco.eboutique.model.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.eboutique.entity.User;

public interface IUserDao {

	List<User> getUtilisateur() throws SQLException;
	User getUtilisateurById(Integer id) throws SQLException;
	User addUtilisateur(User utilisateurs) throws Exception;
}
