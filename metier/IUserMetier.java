package fr.doranco.projetFinal.metier;

import fr.doranco.projetFinal.entity.User;

public interface IUserMetier {

	User seConnecter(String email, String password) throws Exception;
	User addUser(User user) throws Exception;
}
