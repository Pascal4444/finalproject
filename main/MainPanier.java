package fr.doranco.projetFinal.main;

import java.util.List;

import fr.doranco.projetFinal.entity.Article;
import fr.doranco.projetFinal.entity.ArticlePanier;
import fr.doranco.projetFinal.entity.User;
import fr.doranco.projetFinal.model.dao.impl.ArticleDao;
import fr.doranco.projetFinal.model.dao.impl.UserDao;
import fr.doranco.projetFinal.model.dao.interfaces.IArticleDao;
import fr.doranco.projetFinal.model.dao.interfaces.IUserDao;

public class MainPanier {

	public static void main(String[] args) {

		try {
			IUserDao userDao = new UserDao();
			User user = userDao.get(User.class, 1);
			
			IArticleDao articleDao = new ArticleDao();
			Article article1 = articleDao.get(Article.class, 2);
			Article article2 = articleDao.get(Article.class, 3);
			
			ArticlePanier articlePanier1 = new ArticlePanier();
			articlePanier1.setArticle(article1);
			articlePanier1.setQuantite(11);
			articlePanier1.setUser(user);
			
			ArticlePanier articlePanier2 = new ArticlePanier();
			articlePanier2.setArticle(article2);
			articlePanier2.setQuantite(13);
			articlePanier2.setUser(user);
			
			user.getArticle().add(articlePanier1);
			user.getArticle().add(articlePanier2);
			
			userDao.update(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
