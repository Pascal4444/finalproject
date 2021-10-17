package fr.doranco.eboutique.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.eboutique.entity.Article;
import fr.doranco.eboutique.entity.Commentaire;
import fr.doranco.eboutique.entity.Utilisateur;
import fr.doranco.eboutique.model.connection.DataSourceConnexion;

public class CommentaireDao implements ICommentaireDao {

	private static final DataSourceConnexion MDB = new DataSourceConnexion();
	private Connection connexion = null;
	
	public CommentaireDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Commentaire> getCommentaire() throws SQLException {
		List<Commentaire> listcomment = new ArrayList<>();
		
		String request = "SELECT * FROM commentaire";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Commentaire commentaire = new Commentaire();
			commentaire.setId(rs.getInt(1));
			commentaire.setTexte(rs.getString(2));
			commentaire.setNote(rs.getInt(3));
			//commentaire.setArticle(rs.getClass(4));
			//commentaire.setUtilisateur(rs.get(5));
			listcomment.add(commentaire);
		}
		return listcomment;
	}

	@Override
	public Commentaire getCommentaireById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commentaire addCommentaire(Commentaire comment) throws Exception {
		String request = "Insert into commentaire(texte, note, article, utilisateur)values ( ?, ?, ?, ?)";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		Article article = comment.getArticle();
		Utilisateur user = comment.getUtilisateur();
		ps.setString(1, comment.getTexte());
		ps.setInt(2, comment.getNote());
		ps.setInt(3, article.getId());
		ps.setInt(4, user.getId());
		
		int nbLigneAjoutees = ps.executeUpdate();
		if (nbLigneAjoutees == 0) {
			throw new SQLException("Erreur ! l'employé n'a pas pu être ajouté à la BDD !");
		} else if (nbLigneAjoutees > 1) {
			throw new SQLException("Erreur ! Trop de lignes (" + nbLigneAjoutees + ") insérées dans la BDD !");
		}
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			comment.setId(rs.getInt(1));
		}
		return comment;
	}

	@Override
	public List<Commentaire> getCommentairebyArticle(Integer id) throws SQLException {
		List<Commentaire> listcomment = new ArrayList<>();
		
		String request = "SELECT * FROM commentaire WHERE article = ?";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Commentaire commentaire = new Commentaire();
			commentaire.setId(rs.getInt(1));
			commentaire.setTexte(rs.getString(2));
			commentaire.setNote(rs.getInt(3));
				// Récupération Article
				int iduser = rs.getInt(5);
				Utilisateur user = new Utilisateur();
				IUtilisateurDao userDao = new UtilisateurDao();
				user = userDao.getUtilisateurById(iduser);

			commentaire.setUtilisateur(user);
			listcomment.add(commentaire);
		}
		return listcomment;
	}

}
