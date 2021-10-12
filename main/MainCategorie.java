package fr.doranco.projetFinal.main;

import fr.doranco.projetFinal.entity.Categorie;
import fr.doranco.projetFinal.entity.Article;
import fr.doranco.projetFinal.entity.Adresse;
import fr.doranco.projetFinal.entity.User;
import fr.doranco.projetFinal.model.dao.impl.CategorieDao;
import fr.doranco.projetFinal.model.dao.impl.UserDao;
import fr.doranco.projetFinal.model.dao.interfaces.ICategorieDao;
import fr.doranco.projetFinal.model.dao.interfaces.IUserDao;


public class MainCategorie {
	
	public static void main(String[] args) {
		
		try {
			ICategorieDao cDao = new CategorieDao();
			Categorie c = cDao.get(Categorie.class, 1);
			c.getArticles().forEach(a -> System.out.println(a));
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
