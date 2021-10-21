package fr.doranco.eboutique.vue.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.metier.IUserMetier;
import fr.doranco.eboutique.metier.UserMetier;

@ManagedBean(name = "utilisateurBean")
@SessionScoped
public class GestionAdminBean {

	private String nom;
	private String prenom;
	private String dateNaissance;
	private String email;
	private String password;
	private String profil;
	
	private final IUserMetier utilisateurMetier = new UserMetier();
	private User connectedUtilisateur;
	private String errorMessage;
	
	public GestionAdminBean() {
	}

	public String addUtilisateur() {
		
		User utilisateur = new User();
		//
		
		try {
			connectedUtilisateur = (User) utilisateurMetier.addUser(utilisateur);
			return "login.xhtml";
		} catch (Exception e) {
			this.errorMessage = "Erreur technique, veuillez réessayer plus tard\n"
					+ "Erreur : " + e;
			return "";
		}
		
	}
	
	public List<String> getProfils() {
		return new ArrayList<String>(Arrays.asList("", "Client", "Magasinier", "Admin"));
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public User getConnectedUtilisateur() {
		return connectedUtilisateur;
	}

	public void setConnectedUtilisateur(User connectedUtilisateur) {
		this.connectedUtilisateur = connectedUtilisateur;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
