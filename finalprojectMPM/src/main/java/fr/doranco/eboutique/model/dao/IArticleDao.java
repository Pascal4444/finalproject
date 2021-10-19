package fr.doranco.eboutique.model.dao;

import java.util.List;

import fr.doranco.eboutique.entity.Article;
import fr.doranco.eboutique.entity.Categorie;
import fr.doranco.eboutique.entity.Commentaire;

public interface IArticleDao {

	void addArticle(Article article) throws Exception;
	void updateArticle(Article article) throws Exception;
	void deleteArticle(Integer id) throws Exception;
	Article getArticleById(Integer id) throws Exception;
	// @OneToMany _ @OneToOne _ @ManyToOne
	Categorie getCategorieByArticle(Integer category_id) throws Exception;
	List<Commentaire> getCommentaireByArticle(Integer id) throws Exception;
}
