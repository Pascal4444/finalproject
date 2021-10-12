package fr.doranco.projetFinal.main;

import fr.doranco.projetFinal.entity.Adresse;
import fr.doranco.projetFinal.entity.Article;
import fr.doranco.projetFinal.entity.Categorie;
import fr.doranco.projetFinal.entity.User;
import fr.doranco.projetFinal.model.dao.impl.CategorieDao;
import fr.doranco.projetFinal.model.dao.impl.UserDao;
import fr.doranco.projetFinal.model.dao.interfaces.ICategorieDao;
import fr.doranco.projetFinal.model.dao.interfaces.IUserDao;


public class MainAdresse {
	
	public static void main(String[] args) {
		
		try {
			UserDao userDao = new UserDao();
			User user = userDao.get(User.class, 1);
			user.setPrenom("Vanessa");
			Adresse adresse = new Adresse();
			adresse.setNumero("125");
			adresse.setRue("Rue de Paris");
			adresse.setVille("Lyon");
			adresse.setCodePostal("69000");
			adresse.setUser(user);
			user.getAdresses().add(adresse);
			userDao.update(user);
							
			System.out.println(user);
			user.getAdresses().forEach(a -> System.out.println(a));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
