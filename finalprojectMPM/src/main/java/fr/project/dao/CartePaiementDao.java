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
		// TODO Auto-generated method stub
		return null;
	}

}
