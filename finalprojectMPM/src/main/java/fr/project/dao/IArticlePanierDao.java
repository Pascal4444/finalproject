package fr.project.dao;

import java.sql.SQLException;
import java.util.List;

import fr.project.entity.ArticlePanier;

public interface IArticlePanierDao {

	List<ArticlePanier> getArticlePanier() throws SQLException;
	ArticlePanier getArticlePanierById(Integer id) throws SQLException;
	ArticlePanier addArticlePanier(ArticlePanier articlePanier) throws Exception;
}
