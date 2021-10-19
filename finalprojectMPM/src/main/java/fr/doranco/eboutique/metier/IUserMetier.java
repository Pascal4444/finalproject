package fr.doranco.eboutique.metier;

import fr.doranco.eboutique.entity.User;

public interface IUserMetier {

	User seConnecter(String email, byte[] password) throws Exception;
	User addUser(User user) throws Exception;
}
