package fr.doranco.eboutique.vue.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import fr.doranco.eboutique.entity.Adresse;
import fr.doranco.eboutique.entity.CartePaiement;
import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.metier.IUserMetier;
import fr.doranco.eboutique.metier.UserMetier;

@ManagedBean(name = "utilisateurBean")
@SessionScoped
public class UtilisateurBean {

	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String email;
	private byte[] password;
	private String profil;
	private boolean isActif;
	private String telephone;
	private String commentaire;
	private CartePaiement carteDePaiementDefault;
	private Adresse adresseFacturationDefault;
	private Adresse adresseLivraisonDefault;
	
	private final IUserMetier utilisateurMetier = new UserMetier();
	private User connectedUtilisateur;
	private String errorMessage;
	
	public UtilisateurBean() {
	}

	public String addUser() {
		
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public CartePaiement getCarteDePaiementDefault() {
		return carteDePaiementDefault;
	}

	public void setCarteDePaiementDefault(CartePaiement carteDePaiementDefault) {
		this.carteDePaiementDefault = carteDePaiementDefault;
	}

	public Adresse getAdresseFacturationDefault() {
		return adresseFacturationDefault;
	}

	public void setAdresseFacturationDefault(Adresse adresseFacturationDefault) {
		this.adresseFacturationDefault = adresseFacturationDefault;
	}

	public Adresse getAdresseLivraisonDefault() {
		return adresseLivraisonDefault;
	}

	public void setAdresseLivraisonDefault(Adresse adresseLivraisonDefault) {
		this.adresseLivraisonDefault = adresseLivraisonDefault;
	}

	public IUserMetier getUtilisateurMetier() {
		return utilisateurMetier;
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
