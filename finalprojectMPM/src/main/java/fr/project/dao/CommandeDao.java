package fr.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.project.connexion.DataSourceConnexion;
import fr.project.entity.Commande;

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
			int idAdresseExpedition = 0, idAdresseLivraison = 0;
			cm.setId(rs.getInt(1));
			cm.setNumero(rs.getString(2));
			cm.setDateCommande(rs.getDate(3));
			cm.setDateLivraison(rs.getDate(4));
			cm.setTotalRemise(rs.getDouble(5));
			cm.setFraisExpedition(rs.getDouble(6));
			cm.setTotal_general(rs.getDouble(7));
			idAdresseExpedition = rs.getInt(8);
			// Récupérer l'adresse avec id User ou Enregistrer une adresse
			idAdresseLivraison = rs.getInt(9);
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
		// TODO Auto-generated method stub
		return null;
	}

}
