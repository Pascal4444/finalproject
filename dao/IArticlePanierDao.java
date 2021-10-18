package fr.doranco.eboutique.model.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.eboutique.entity.ArticlePanier;

public interface IArticlePanierDao {

	List<ArticlePanier> getArticlePanier() throws SQLException;
	ArticlePanier getArticlePanierById(Integer id) throws SQLException;
	ArticlePanier addArticlePanier(ArticlePanier articlePanier) throws Exception;
}
