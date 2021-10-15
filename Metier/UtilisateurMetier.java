package fr.doranco.projetFinal.metier;

import fr.doranco.projetFinal.entity.Utilisateur;
import fr.doranco.projetFinal.model.dao.IUserDao;
import fr.doranco.projetFinal.model.dao.IUtilisateurDao;
import fr.doranco.projetFinal.model.dao.UserDao;
import fr.doranco.projetFinal.model.dao.UtilisateurDao;


public class UtilisateurMetier implements IUtilisateurMetier {

	private final IUtilisateurDao utilisateurDao = new UtilisateurDao();
	
	@Override
	public Utilisateur seConnecter(String email, String password) throws Exception {
		Utilisateur utilisateur = utilisateurDao.getUtilisateurByEmail(email);
		if (utilisateur != null) {
			if (utilisateur.getPassword().equals(password)) {
				return utilisateur;
			}
		}
		return null;
	}

	@Override
	public User addUser(User user) throws Exception {
		user.setNom(user.getNom().trim().toUpperCase());
		user.setPrenom(user.getPrenom().trim().toLowerCase());
		
		return userDao.addUser(user);
	}

	@Override
	public Object addUtilisateur(Object utilisateur) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
