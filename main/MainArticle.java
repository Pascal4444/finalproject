package fr.doranco.projetFinal.main;

import org.hibernate.Session;

import fr.doranco.projetFinal.entity.Article;
import fr.doranco.projetFinal.entity.Categorie;
import fr.doranco.projetFinal.entity.model.dao.ArticleDao;
import fr.doranco.projetFinal.model.dao.impl.CategorieDao;
import fr.doranco.projetFinal.model.dao.interfaces.ICategorieDao;
import fr.doranco.projetFinal.model.datasource.HibernateConnector;

public class MainArticle {

	public static void main(String[] args) {

		try {
			Categorie categorie = new Categorie();
			categorie.setNom("Multimedia-TV");
			categorie.setDescription("Produits Multimedia-Téléviseurs");
			
			Article article = new Article();
			article.setNom("TV");
			article.setRemise(5);
			article.setDescription("C'est un TV LED 16cm");
			article.setPrix(699.99);
			
			
			article.setCategorie(categorie);
			categorie.getArticles().add(article);
			
			ICategorieDao cDao = new CategorieDao();
			cDao.add(categorie);
			
			IArticleDao articleDao = new ArticleDao();	
			System.out.println("Articles dispos :");
			articleDao.getAllAvailable().forEach(a -> System.out.println(a));
			System.out.println("Articles vendables :");
			articleDao.getAllSalable().forEach(a -> System.out.println(a));
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
