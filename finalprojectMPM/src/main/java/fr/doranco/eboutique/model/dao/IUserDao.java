package fr.doranco.eboutique.model.dao;

import java.util.List;
import java.lang.Exception;

import fr.doranco.eboutique.entity.User;

public interface IUserDao {

	User addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	void deleteUser(Integer id) throws Exception;
	User getUserById(Integer id) throws Exception;
	// En plus
	User getUserByEmail(String email) throws Exception;	
	List<User> getUserByVille(String ville) throws Exception;
}