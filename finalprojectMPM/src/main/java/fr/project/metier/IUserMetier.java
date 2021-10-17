package fr.project.metier;

import fr.project.entity.Utilisateur;

public interface IUserMetier {

	User seConnecter(String email, String password) throws Exception;
	User addUser(User user) throws Exception;
}
