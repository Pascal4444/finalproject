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
import fr.project.entity.CartePaiement;
import fr.project.entity.Utilisateur;
import fr.project.utils.Dates;

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
	public Utilisateur addUtilisateur(Utilisateur user) throws Exception {
		String request = "Insert into utilisateur(nom, prenom, date_naissance, profil, email, password, telephone, adresses_default, cartes_de_paiement, commentaires)values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		Adresse adresse = user.getAdressedefault();
		CartePaiement cp = user.getCartePaiementdefault();
		ps.setString(1, user.getNom());
		ps.setString(2, user.getPrenom());
		ps.setDate(3, Dates.dateUtilToSql(user.getDateNaissance()));
		ps.setString(4, user.getProfil());
		ps.setString(5, user.getEmail());
		ps.setBytes(6, user.getPassword());
		ps.setString(7, user.getTelephone());
		ps.setInt(8, adresse.getId());
		ps.setInt(9, cp.getId());
		ps.setString(10, user.getCommentaires());
		
		int nbLigneAjoutees = ps.executeUpdate();
		if (nbLigneAjoutees == 0) {
			throw new SQLException("Erreur ! l'employé n'a pas pu être ajouté à la BDD !");
		} else if (nbLigneAjoutees > 1) {
			throw new SQLException("Erreur ! Trop de lignes (" + nbLigneAjoutees + ") insérées dans la BDD !");
		}
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			user.setId(rs.getInt(1));
		}
		return user;
	}

	@Override
	public Utilisateur getUserByEmail(String email) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String request = "call projet_final_db.cutilisateur_email(?)";
			connexion = MDB.getConnection();
			ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, email);
			rs = ps.executeQuery();
			Utilisateur user = null;
			if (rs != null && rs.next()) {
				user = new Utilisateur();
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setDateNaissance(Dates.dateSqlToUtil(rs.getDate("date_naissance")));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getBytes("password"));
				user.setProfil(rs.getString("profil"));
			}
			return user;
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connexion != null && !connexion.isClosed()) {
				connexion.close();
			}
		}
	}

}
