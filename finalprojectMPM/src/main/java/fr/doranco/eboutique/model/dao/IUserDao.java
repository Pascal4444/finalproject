package fr.doranco.eboutique.model.dao;

import java.util.List;
import java.lang.Exception;

import fr.doranco.eboutique.entity.User;

public interface IUserDao {

	User getUserById(Integer id) throws Exception;
	List<User> getUserByVille(String ville) throws Exception;
	User getUserByEmail(String email) throws Exception;
	void addUser(User utilisateur) throws Exception;
	void updateUser(User utilisateur) throws Exception;
	void removeUser(Integer id) throws Exception;
}