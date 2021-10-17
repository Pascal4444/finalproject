package fr.doranco.eboutique.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class User2 {

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
	
	private Adresse adressedefault;
	
	private List<Adresse> adresses;
	
	private List<Commande> commandes;
	
	private CartePaiement cartePaiementdefault;
	
	private List<CartePaiement> cartesPaiement;
	
	// On se commente sois-meme
	private String commentaires;
	
	public User2() {
		this.commandes = new ArrayList<Commande>();
		this.adresses = new ArrayList<Adresse>();
		this.cartesPaiement = new ArrayList<CartePaiement>();
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

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	
	public Adresse getAdressedefault() {
		return adressedefault;
	}

	public void setAdressedefault(Adresse adressedefault) {
		this.adressedefault = adressedefault;
		if (adresses.contains(adressedefault)) {
		    System.out.println("Adresse existant");
		} else {
		    System.out.println("Enregistrement de l'adresse");
		    adresses.add(adressedefault);
		}
	}

	
	public CartePaiement getCartePaiementdefault() {
		return cartePaiementdefault;
	}

	public void setCartePaiementdefault(CartePaiement cartePaiementdefault) {
		this.cartePaiementdefault = cartePaiementdefault;
		if (cartesPaiement.contains(cartePaiementdefault)) {
		    System.out.println("Moyen existant");
		} else {
		    System.out.println("Enregistrement du moyen de payement");
		    cartesPaiement.add(cartePaiementdefault);
		}
	}

	@Override
	public String toString() {
		return "U [id=" + id + ", genre=" + genre + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", isActif=" + isActif + ", profil=" + profil + ", email=" + email + ", password="
				+ Arrays.toString(password) + ", telephone=" + telephone + "]";
	}

}
