package fr.project.test;

import fr.project.dao.*;
import fr.project.entity.*;

public class testDao {

	public static void main(String[] args) {
		Adresse ad = new Adresse();
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
		}
		

	}

}
