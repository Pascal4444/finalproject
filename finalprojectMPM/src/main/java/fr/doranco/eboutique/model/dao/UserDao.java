package fr.doranco.eboutique.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.eboutique.entity.Adresse;
import fr.doranco.eboutique.entity.CartePaiement;
import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.utils.Dates;

public class UserDao implements IUserDao {

	private Connection connexion = null;
	
	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> getUtilisateur() throws SQLException {

		return listuser;
	}

	@Override
	public User getUtilisateurById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUtilisateur(User user) throws Exception {

	}

}
