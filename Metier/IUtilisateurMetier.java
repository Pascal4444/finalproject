package fr.doranco.projetFinal.metier;

import fr.doranco.projetFinal.entity.Utilisateur;
import fr.doranco.projetFinal.pojo.Utilisateur;

public interface IUtilisateurMetier<Utilisateur> {

	Utilisateur seConnecter(String email, String password) throws Exception;
	Utilisateur addUtilisateur(Utilisateur utilisateur) throws Exception;
}
