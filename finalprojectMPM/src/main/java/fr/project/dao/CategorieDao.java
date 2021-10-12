package fr.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.project.connexion.DataSourceConnexion;
import fr.project.entity.Categorie;

public class CategorieDao implements ICategorieDao {

	private static final DataSourceConnexion MDB = new DataSourceConnexion();
	private Connection connexion = null;
	
	public CategorieDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Categorie> getCategorie() throws SQLException {
		List<Categorie> listcate = new ArrayList<>();
		
		String request = "SELECT * FROM cartegorie";
		connexion = MDB.getConnection();
		PreparedStatement ps = connexion.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Categorie cate = new Categorie();
			cate.setId(rs.getInt(1));
			cate.setNom(rs.getString(2));
			cate.setRemise(rs.getInt(3));
			cate.setRemise(rs.getInt(4));
			//cate.setArticles(rs.get(5));
			listcate.add(cate);
		}
		return listcate;
	}

	@Override
	public Categorie getCategorieById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie addCategorie(Categorie categorie) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
