package fr.doranco.pf_cryptage.dao;

import java.security.Key;
import fr.doranco.pf_cryptage.entity.User;

public interface IParamsDAO {

	User addUser(User user) throws Exception;
	User getUserByEmail(String email) throws Exception;
	boolean testEmailPassword (String email, String enteredPassword) throws Exception;

//	IParamsDAO paramsDAO = new ParamDAO();
//	Key Key = paramDAO.getKey();
//	String message = "Sarah";
//	byte[] passwordCrypte = CryptageDES.encryptDES(message, key);
//	User user = new User ("Maman", "s.y@gmail.com", passwordCrypte);
	
	
//	IUserDAO userDAO = new UserDAO():
	try {
//		User addedUser = userDAO.addUser(user);
//		System.out.println(addedUser);
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
  }

}