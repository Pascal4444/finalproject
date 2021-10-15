package fr.doranco.eboutique.metier;

import fr.doranco.eboutique.entity.User;

public interface IUserMetier {

	User seConnecter(String email, String password) throws Exception;
	User addUser(User user) throws Exception;
}
