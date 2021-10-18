package fr.doranco.pf_cryptage.dao;

import fr.doranco.pf_cryptage.entity.User;

public interface IUserDAO {
	
	User addUser(User user) throws Exception;
	User getUserByEmail(String email) throws Exception;
	boolean testEmailPassword (String email, String enteredPassword) throws Exception;
	
	
	

}
