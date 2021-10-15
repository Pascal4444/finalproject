package fr.project.metier;

import fr.project.entity.Utilisateur;

public interface IUserMetier {

	Utilisateur seConnecter(String email, String password) throws Exception;
	Utilisateur addUser(Utilisateur user) throws Exception;
}
