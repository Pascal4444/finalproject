package fr.doranco.eboutique.metier;

import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.model.dao.IUserDao;
import fr.doranco.eboutique.model.dao.UserDao;

public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();
	
	@Override
	public User seConnecter(String email, byte[] password) throws Exception {
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
		user.setDateNaissance(user.getDateNaissance());
		user.setEmail(user.getEmail().trim().toLowerCase());
		user.setPassword(user.getPassword());
		user.setProfil(user.getProfil().trim().toLowerCase());
		user.setIsActif(user.getIsActif());
		user.setTelephone(user.getTelephone().trim().toUpperCase());
		user.setCommentaire(user.getCommentaire());
		
		return userDao.addUser(user);
	}

}
