package fr.project.metier;

import fr.project.entity.Utilisateur;
import fr.project.dao.IUtilisateurDao;
import fr.project.dao.UtilisateurDao;

public class UserMetier implements IUserMetier {

	private final IUtilisateurDao userDao = new UtilisateurDao();
	
	@Override
	public User seConnecter(String email, String password) throws Exception {
		User user = userDao.getUserByEmail(email);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User addUser(User user) throws Exception {
		user.setNom(user.getNom().trim().toUpperCase());
		user.setPrenom(user.getPrenom().trim().toLowerCase());
		
		return userDao.addUtilisateur(user);
	}

}
