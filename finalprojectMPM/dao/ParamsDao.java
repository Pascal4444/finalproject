package fr.doranco.eboutique.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.eboutique.entity.Params;
import fr.doranco.eboutique.model.connection.DataSourceConnexion;

public class ParamsDao implements IParamsDao {

	private static final DataSourceConnexion MDB = new DataSourceConnexion();
	private Connection connexion = null;
	
	public ParamsDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Params> getParams() throws SQLException {
		List<Params> listparams = new ArrayList<>();
		
		String request = "SELECT * FROM params";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Params params = new Params();
			params.setId(rs.getInt(1));
			params.setCleCryptagePwd(rs.getBytes(2));
			params.setCleCryptageCp(rs.getBytes(3));
			listparams.add(params);
		}
		return listparams;
	}

	@Override
	public Params getParamsById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Params addParams(Params params) throws Exception {
		String request = "Insert into params(cle_cryptage_pwd, cle_cryptage_cp)values (?, ?)";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ps.setBytes(1, params.getCleCryptagePwd());
		ps.setBytes(2, params.getCleCryptageCp());
		
		int nbLigneAjoutees = ps.executeUpdate();
		if (nbLigneAjoutees == 0) {
			throw new SQLException("Erreur ! l'employé n'a pas pu être ajouté à la BDD !");
		} else if (nbLigneAjoutees > 1) {
			throw new SQLException("Erreur ! Trop de lignes (" + nbLigneAjoutees + ") insérées dans la BDD !");
		}
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			params.setId(rs.getInt(1));
		}
		return params;
	}

}
