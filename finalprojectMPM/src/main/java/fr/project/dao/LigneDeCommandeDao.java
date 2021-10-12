package fr.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.project.connexion.DataSourceConnexion;
import fr.project.entity.LigneDeCommande;

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
	public LigneDeCommande addLigneDeCommande(LigneDeCommande ligneDeCommande) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
