package fr.doranco.eboutique.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.eboutique.entity.Article;
import fr.doranco.eboutique.entity.Commande;
import fr.doranco.eboutique.entity.LigneDeCommande;
import fr.doranco.eboutique.model.connector.DataSourceConnexion;

public class LigneDeCommandeDao implements ILigneDeCommandeDao {

	private static final DataSourceConnexion MDB = new DataSourceConnexion();
	private Connection connexion = null;
	
	public LigneDeCommandeDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<LigneDeCommande> getLigneDeCommande() throws SQLException {
		List<LigneDeCommande> listLigne = new ArrayList<>();
		
		String request = "SELECT * FROM ligne_de_commande";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			LigneDeCommande ligne = new LigneDeCommande();
			ligne.setId(rs.getInt(1));
			ligne.setQuantite(rs.getInt(2));
			ligne.setPrixArticle(rs.getDouble(3));
			ligne.setRemiseArticle(rs.getDouble(4));
			//ligne.setTitreArticle(rs.getInt(5));
			listLigne.add(ligne);
		}
		return listLigne;
	}

	@Override
	public LigneDeCommande getLigneDeCommandeById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneDeCommande addLigneDeCommande(LigneDeCommande ldc) throws Exception {
		String request = "Insert into ligne_de_commande(quantite, prix_unitaire, remise_article, commande, article)values (?, ?, ?, ?, ?)";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		Commande commande = ldc.getCommande();
		Article article = ldc.getArticle();
		ps.setInt(1, ldc.getQuantite());
		ps.setDouble(2, ldc.getPrixArticle());
		ps.setDouble(3, ldc.getRemiseArticle());
		ps.setInt(4, commande.getId());
		ps.setInt(5, article.getId());
		
		int nbLigneAjoutees = ps.executeUpdate();
		if (nbLigneAjoutees == 0) {
			throw new SQLException("Erreur ! l'employé n'a pas pu être ajouté à la BDD !");
		} else if (nbLigneAjoutees > 1) {
			throw new SQLException("Erreur ! Trop de lignes (" + nbLigneAjoutees + ") insérées dans la BDD !");
		}
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			ldc.setId(rs.getInt(1));
		}
		return ldc;
	}

}
