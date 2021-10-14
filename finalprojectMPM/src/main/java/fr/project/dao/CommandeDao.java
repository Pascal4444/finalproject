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
import fr.project.entity.Commande;
import fr.project.entity.Utilisateur;
import fr.project.utils.Dates;

public class CommandeDao implements ICommandeDao {

	private static final DataSourceConnexion MDB = new DataSourceConnexion();
	private Connection connexion = null;
	
	public CommandeDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Commande> getCommande() throws SQLException {
		List<Commande> listcommande = new ArrayList<>();
		
		String request = "SELECT * FROM commande";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Commande cm = new Commande();
			/*int idAdresseExpedition = 0;
			int idAdresseLivraison = 0;*/
			cm.setId(rs.getInt(1));
			cm.setNumero(rs.getString(2));
			cm.setDateCommande(rs.getDate(3));
			cm.setDateLivraison(rs.getDate(4));
			cm.setTotalRemise(rs.getDouble(5));
			cm.setFraisExpedition(rs.getDouble(6));
			cm.setTotal_general(rs.getDouble(7));
			/*idAdresseExpedition = rs.getInt(8);
			// Récupérer l'adresse avec id User ou Enregistrer une adresse
			idAdresseLivraison = rs.getInt(9);*/
			// Récupérer l'adresse avec id User ou Enregistrer une adresse
			cm.setCartePaiementDefaut(rs.getInt(10));
			// cm.setUtilisateur(rs.getInt(11));
			// cm.setLigneDeCommande(rs.get(12));
			listcommande.add(cm);
		}
		return listcommande;
	}

	@Override
	public Commande getCommandeById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande addCommande(Commande commande) throws Exception {
		String request = "Insert into commande(numero, date_creation, date_livraison, total_remise, frais_expedition, total_general, adresse_facturation, adresse_livraison, carte_paiement_default, utilisateur)values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		Adresse adresseF = commande.getAdresseFacturation();
		Adresse adresseL = commande.getAdresseLivraison();
		Utilisateur user = commande.getUtilisateur();
		ps.setString(1, commande.getNumero());
		ps.setDate(2, Dates.dateUtilToSql(commande.getDateCommande()));
		ps.setDate(3, Dates.dateUtilToSql(commande.getDateLivraison()));
		ps.setDouble(4, commande.getTotalRemise());
		ps.setDouble(5, commande.getFraisExpedition());
		ps.setDouble(6, commande.getTotal_general());
		ps.setInt(7, adresseF.getId());
		ps.setInt(8, adresseL.getId());
		// A voir Id ou Numero de carte
		ps.setInt(9, commande.getCartePaiementDefaut());
		ps.setInt(10, user.getId());
		
		int nbLigneAjoutees = ps.executeUpdate();
		if (nbLigneAjoutees == 0) {
			throw new SQLException("Erreur ! l'employé n'a pas pu être ajouté à la BDD !");
		} else if (nbLigneAjoutees > 1) {
			throw new SQLException("Erreur ! Trop de lignes (" + nbLigneAjoutees + ") insérées dans la BDD !");
		}
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			commande.setId(rs.getInt(1));
		}
		return commande;
	}

}
