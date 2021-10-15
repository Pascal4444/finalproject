package fr.doranco.eboutique.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.eboutique.entity.Adresse;
import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.model.connector.DataSourceConnexion;

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
			adresse.setNumero(rs.getString(2));
			adresse.setRue(rs.getString(3));
			adresse.setVille(rs.getString(4));
			adresse.setCodePostal(rs.getString(5));
				// Récupération Utilisateur
				int idUser = rs.getInt(6);
				User user = new User();
				IUserDao userDao = new UserDao();
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
			adresse.setNumero(rs.getString(2));
			adresse.setRue(rs.getString(3));
			adresse.setVille(rs.getString(4));
			adresse.setCodePostal(rs.getString(5));
				// Récupération Utilisateur
				User user = new User();
				user.setId(rs.getInt(6));
				
				//user.setId(idUser);
			adresse.setUtilisateur(user);
		}
		return adresse;
	}

	@Override
	public Adresse addAdresse(Adresse adresse) throws Exception {
		
		String request = "Insert into adresse(numero, rue, ville, codePostal, user_id)values (?, ?, ?, ?, ?)";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		User user = adresse.getUtilisateur();
		ps.setString(1, adresse.getNumero());
		ps.setString(2, adresse.getRue());
		ps.setString(3, adresse.getVille());
		ps.setString(4, adresse.getCodePostal());
		ps.setInt(5, user.getId());
		
		int nbLigneAjoutees = ps.executeUpdate();
		if (nbLigneAjoutees == 0) {
			throw new SQLException("Erreur ! l'employé n'a pas pu être ajouté à la BDD !");
		} else if (nbLigneAjoutees > 1) {
			throw new SQLException("Erreur ! Trop de lignes (" + nbLigneAjoutees + ") insérées dans la BDD !");
		}
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			adresse.setId(rs.getInt(1));
		}
		return adresse;
		
	}

}
