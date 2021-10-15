package fr.project.test;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.project.dao.*;
import fr.project.entity.*;

public class testDao {

	public static void main(String[] args) {
		
		Adresse ad = new Adresse();
		IUtilisateurDao userDao = new UtilisateurDao();
		Utilisateur user;
		String sourceDate = "1999-09-29";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate=null;
		try {
			myDate = format.parse(sourceDate);
		} catch (ParseException e) {
			System.err.println("Erreur Date : ");
			e.printStackTrace();
		}
		String tp = "testpassword";
		byte[] td= null;
		try {
			td = tp.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ad.setId(1);
		
		user = new Utilisateur();
		user.setNom("testnomerr");
		user.setPrenom("testprenomerr");
		user.setDateNaissance(myDate);
		user.setAdressedefault(null);
		user.setProfil("TestPseudo");
		user.setEmail("azer@test");
		user.setPassword(td);
		user.setAdressedefault(ad);
		try {
			userDao.addUtilisateur(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*Adresse test
		 * Adresse ad = new Adresse();
		IAdresseDao adDao = new AdresseDao();
		Utilisateur user = new Utilisateur();
		user.setId(25);
		ad.setNumero("25");
		ad.setRue("Rue du Test");
		ad.setCodePostal("88888");
		ad.setVille("TestVille");
		ad.setUtilisateur(user);
		
		try {
			adDao.addAdresse(ad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

	}

}
