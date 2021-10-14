package fr.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.project.connexion.DataSourceConnexion;
import fr.project.entity.CartePaiement;
import fr.project.entity.Utilisateur;
import fr.project.utils.Dates;

public class CartePaiementDao implements ICartePaiementDao {

	private static final DataSourceConnexion MDB = new DataSourceConnexion();
	private Connection connexion = null;
	
	public CartePaiementDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CartePaiement> getCartePaiement() throws SQLException {
		// A décrypter
		List<CartePaiement> listCarte = new ArrayList<>();
		
		String request = "SELECT * FROM carte_paiement";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			CartePaiement CP = new CartePaiement();
			CP.setId(rs.getInt(1));
			CP.setNomProprietaire(rs.getString(2));
			CP.setPrenomProprietaire(rs.getString(3));
			CP.setNumero(rs.getBytes(4));
			CP.setDateFinValidite(rs.getDate(5));
			CP.setCryptogramme(rs.getBytes(6));
			//CP.setUtilisateur(rs.get(7));
			listCarte.add(CP);
		}
		return listCarte;
	}

	@Override
	public CartePaiement getCartePaiementById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartePaiement addCartePaiement(CartePaiement cartePaiement) throws Exception {
		String request = "Insert into carte_paiement(nom_proprietaire, prenom_proprietaire, numero, date_fin_validite, cryptogramme, utilisateur)values (?, ?, ?, ?, ?, ?)";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		Utilisateur user = cartePaiement.getUtilisateur();
		ps.setString(1, cartePaiement.getNomProprietaire());
		ps.setString(2, cartePaiement.getPrenomProprietaire());
		ps.setBytes(3, cartePaiement.getNumero());
		ps.setDate(4, Dates.dateUtilToSql(cartePaiement.getDateFinValidite()));
		ps.setBytes(5, cartePaiement.getCryptogramme());
		ps.setInt(6, user.getId());
		
		int nbLigneAjoutees = ps.executeUpdate();
		if (nbLigneAjoutees == 0) {
			throw new SQLException("Erreur ! l'employé n'a pas pu être ajouté à la BDD !");
		} else if (nbLigneAjoutees > 1) {
			throw new SQLException("Erreur ! Trop de lignes (" + nbLigneAjoutees + ") insérées dans la BDD !");
		}
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			cartePaiement.setId(rs.getInt(1));
		}
		return cartePaiement;
	}

}
