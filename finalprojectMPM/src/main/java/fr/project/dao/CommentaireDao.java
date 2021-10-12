package fr.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.project.connexion.DataSourceConnexion;
import fr.project.entity.Commentaire;

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
	public Commentaire addCommentaire(Commentaire cours) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
