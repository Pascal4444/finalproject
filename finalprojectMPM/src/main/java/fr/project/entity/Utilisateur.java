package fr.project.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import fr.project.entity.Adresse;
import fr.project.entity.CartePaiement;
import fr.project.entity.Commande;
import fr.project.entity.Commentaire;

public class Utilisateur {

	private Integer id;
	
	private String genre;
	
	private String nom;
	
	private String prenom;
	
	private Date dateNaissance;
	
	private String isActif;
	
	
	private String profil;
	
	private String email;
	
	private byte[] password;
	
	private String telephone;
	
	private List<Adresse> adresses;
	
	private List<Commande> commandes;
	
	private List<CartePaiement> cartesPaiement;
	
	private List<Commentaire> commentaires;
	
	public Utilisateur() {
		this.commandes = new ArrayList<Commande>();
		this.adresses = new ArrayList<Adresse>();
		this.cartesPaiement = new ArrayList<CartePaiement>();
		this.commentaires = new ArrayList<Commentaire>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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

	public String getIsActif() {
		return isActif;
	}

	public void setIsActif(String active) {
		this.isActif = active;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public List<CartePaiement> getCartesPaiement() {
		return cartesPaiement;
	}

	public void setCartesPaiement(List<CartePaiement> cartesPaiement) {
		this.cartesPaiement = cartesPaiement;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	@Override
	public String toString() {
		return "U [id=" + id + ", genre=" + genre + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", isActif=" + isActif + ", profil=" + profil + ", email=" + email + ", password="
				+ Arrays.toString(password) + ", telephone=" + telephone + "]";
	}

}
