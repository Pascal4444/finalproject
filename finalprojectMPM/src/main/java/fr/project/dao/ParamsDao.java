package fr.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.project.connexion.DataSourceConnexion;
import fr.project.entity.Params;

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
		// TODO Auto-generated method stub
		return null;
	}

}
