package fr.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.project.connexion.DataSourceConnexion;
import fr.project.entity.Utilisateur;

public class UtilisateurDao implements IUtilisateurDao {

	private static final DataSourceConnexion MDB = new DataSourceConnexion();
	private Connection connexion = null;
	
	public UtilisateurDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Utilisateur> getUtilisateur() throws SQLException {
		List<Utilisateur> listuser = new ArrayList<>();
		
		String request = "SELECT * FROM adresse";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Utilisateur user = new Utilisateur();
			user.setId(rs.getInt(1));
			user.setNom(rs.getString(2));
			user.setPrenom(rs.getString(3));
			user.setDateNaissance(rs.getDate(4));
			user.setIsActif(rs.getString(5));
			user.setProfil(rs.getString(6));
			user.setEmail(rs.getString(7));
			user.setPassword(rs.getBytes(8));
			user.setTelephone(rs.getString(9));
			//user.setAdresses(rs.getInt(10));
			//user.setCommandes(rs.get(11));
			//user.setCartesPaiement(rs.getString(12));
			//user.setCommentaires(rs.get(13));
			listuser.add(user);
		}
		return listuser;
	}

	@Override
	public Utilisateur getUtilisateurById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur addUtilisateur(Utilisateur utilisateurs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
