package fr.doranco.eboutique.model.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.eboutique.entity.Article;

public interface IArticleDao {

	List<Article> getArticles() throws SQLException;
	List<Article> getArticlesByCategorieId(Integer id) throws Exception;
	List<Article> getArticlesByCategorieName(String name) throws Exception;
	List<Article> addArticles(Article article) throws Exception;
}