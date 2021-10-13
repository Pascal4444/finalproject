package fr.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.project.connexion.DataSourceConnexion;
import fr.project.entity.Adresse;
import fr.project.entity.Utilisateur;

public class AdresseDao implements IAdresseDao {

	private static final DataSourceConnexion MDB = new DataSourceConnexion();
	private Connection connexion = null;
	
	public AdresseDao() {
		
	}

	@Override
	public List<Adresse> getAdresse() throws SQLException {
		List<Adresse> listadresse = new ArrayList<>();
		
		String request = "SELECT * FROM adresse";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Adresse adresse = new Adresse();
			adresse.setId(rs.getInt(1));
			adresse.setNumero(rs.getInt(2));
			adresse.setRue(rs.getString(3));
			adresse.setVille(rs.getString(4));
			adresse.setCodePostal(rs.getString(5));
				// Récupération Utilisateur
				int idUser = rs.getInt(6);
				Utilisateur user = new Utilisateur();
				IUtilisateurDao userDao = new UtilisateurDao();
				user = userDao.getUtilisateurById(idUser);
				
				//user.setId(idUser);
			adresse.setUtilisateur(user);
			listadresse.add(adresse);
		}
		return listadresse;
	}

	@Override
	public Adresse getAdresseById(Integer id) throws SQLException {
		Adresse adresse = new Adresse();
		String request = "SELECT * FROM adresse WHERE id = ?";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			adresse.setId(rs.getInt(1));
			adresse.setNumero(rs.getInt(2));
			adresse.setRue(rs.getString(3));
			adresse.setVille(rs.getString(4));
			adresse.setCodePostal(rs.getString(5));
				// Récupération Utilisateur
				int idUser = rs.getInt(6);
				Utilisateur user = new Utilisateur();
				IUtilisateurDao userDao = new UtilisateurDao();
				user = userDao.getUtilisateurById(idUser);
				
				//user.setId(idUser);
			adresse.setUtilisateur(user);
		}
		return adresse;
	}

	@Override
	public Adresse addAdresse(Adresse adresse) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
