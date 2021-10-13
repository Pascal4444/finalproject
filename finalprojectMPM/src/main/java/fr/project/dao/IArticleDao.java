package fr.project.dao;

import java.sql.SQLException;
import java.util.List;

import fr.project.entity.Article;

public interface IArticleDao {

	List<Article> getArticle() throws SQLException;
	Article getArticleById(Integer id) throws SQLException;
	Article addArticle(Article article) throws Exception;
}
