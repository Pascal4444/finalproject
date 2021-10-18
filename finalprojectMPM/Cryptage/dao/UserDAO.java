package fr.doranco.pf_cryptage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.crypto.SecretKey;

import fr.doranco.pf_cryptage.utils.CryptageDES;
import fr.doranco.pf_cryptage.entity.User;

public class UserDAO {

	public static void main(String[] args) {
		
		
		// Clé de cryptage
		SecretKey key = CryptageDES.generateKey();
		
		// Etablir la connection avec la base de données (security_db)
		Connection connection = CryptageDataSource.getConnection();
		System.out.println("Connection établie !");
		System.out.println(connection);		
		
		//Requete ajout
		
		public User addUser(User user) throws Exception {
		String requete = "INSERT INTO user(nom, prenom, email, password) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS)
		ps.setString(1, user.getNom());	
		ps.setString(2, user.getPrenom());	
		ps.setString(3, user.getEmail());			
		ps.setString(4, key.getEncoded());	
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		Integer idUser = rs.getInt(1);
		if (rs.next()) {
			idUser = rs.getInt(1);
			user.setId(idUser);
			System.out.println("La clé user password a été crée et l'id est " + idUser);
		}
		return user;
		
	}	
		
		public boolean testEmailPassword(String email ; String enteredPassword) throws Exception {
		User user = this.getUserByEmail(email);
		
		UserDAO param = new UserDAO();
		Key key = param.getKey();
		String registeredPassword = CryptageDES.decryptDES(user.getPassword(), key);
		
		return registeredPassword.equals(enteredPassword);
	}
		
		public Key getKey() {
		String requete = "SELECT password FROM params WHERE id = 1";
		Connection connnection;
		SecretKey key = null;
		
		try {
			connection = CryptageDataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(requete);
			ResultSet rs = ps.executeQuery();
			if(rs != null && rs.next()) {
				byte[] byteey = rs.getBytes("password");
				key = new SecretKeySpec(byteKey, "DES");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;	
			
			
		}
		
		
		
	}

}
