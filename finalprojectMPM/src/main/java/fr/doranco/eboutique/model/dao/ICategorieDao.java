package fr.doranco.eboutique.model.dao;

import java.util.List;

import fr.doranco.eboutique.entity.Article;
import fr.doranco.eboutique.entity.Categorie;

public interface ICategorieDao {

	void addCategorie(Categorie cate) throws Exception;
	void updateCategorie(Categorie cate) throws Exception;
	void deleteCategorie(Integer id) throws Exception;
	Categorie getCategorieById(Integer id) throws Exception;
	// @OneToMany _ @OneToOne _ @ManyToOne
	List<Article> getArticleByCategorie(Integer id) throws Exception;
}
