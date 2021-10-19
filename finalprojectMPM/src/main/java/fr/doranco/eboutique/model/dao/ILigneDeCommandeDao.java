package fr.doranco.eboutique.model.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.eboutique.entity.Adresse;
import fr.doranco.eboutique.entity.Article;
import fr.doranco.eboutique.entity.ArticlePanier;
import fr.doranco.eboutique.entity.LigneDeCommande;

public interface ILigneDeCommandeDao {

	void addArticlePannier(ArticlePanier articlepanier) throws Exception;
	void updateArticlePanier(ArticlePanier articlepanier) throws Exception;
	void deleteArticlePanier(Integer id) throws Exception;
	Article getArticleById(Integer id) throws Exception;
	// @OneToMany _ @OneToOne _ @ManyToOne
}
