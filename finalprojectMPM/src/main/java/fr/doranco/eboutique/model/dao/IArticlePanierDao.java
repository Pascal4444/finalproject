package fr.doranco.eboutique.model.dao;

import fr.doranco.eboutique.entity.Article;
import fr.doranco.eboutique.entity.ArticlePanier;
import fr.doranco.eboutique.entity.User;

public interface IArticlePanierDao {

	void addArticlePanier(ArticlePanier articlepanier) throws Exception;
	void updateArticlePanier(ArticlePanier articlepanier) throws Exception;
	void deleteArticlePanier(Integer id) throws Exception;
	ArticlePanier getArticlePanierById(Integer id) throws Exception;
	// @OneToMany _ @OneToOne _ @ManyToOne
	Article getArticleByArticlePanier(Integer article_id) throws Exception;
	User getUserByArticlePanier(Integer user_id) throws Exception;
}
