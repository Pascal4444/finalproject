package fr.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.project.connexion.DataSourceConnexion;
import fr.project.entity.Article;

public class ArticleDao implements IArticleDao {

	private static final DataSourceConnexion MDB = new DataSourceConnexion();
	private Connection connexion = null;
	
	public ArticleDao() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Article> getArticle() throws SQLException {
		List<Article> listarticle = new ArrayList<>();
		
		String request = "SELECT * FROM article";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Article article = new Article();
			article.setId(rs.getInt(1));
			article.setNom(rs.getString(2));
			article.setDescription(rs.getString(3));
			article.setPrix(rs.getDouble(4));
			article.setRemise(rs.getInt(5));
			article.setStock(rs.getInt(6));
			article.setIsVendable(rs.getBoolean(7));
			//article.setCommentaires(rs.getList<Commentaire>(8));
			//article.setCategorie(rs.get);
			listarticle.add(article);
		}
		return listarticle;
	}

	@Override
	public Article getArticleById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article addArticle(Article article) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
