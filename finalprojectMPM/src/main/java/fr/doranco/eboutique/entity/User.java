package fr.doranco.eboutique.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "utilisateur")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotEmpty
	@Column(name = "nom", nullable = false)
	private String nom;

	@NotEmpty
	@Column(name = "prenom", nullable = false)
	private String prenom;

	@NotNull
	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Column(name = "actif", columnDefinition="tinyint(1) default 1")
	private boolean isActif;
	
	@NotEmpty
	@Column(name = "profil", nullable = true)
	private String profil;
	
	@NotEmpty
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@NotNull
	@Column(name = "password", nullable = false)
	private byte[] password;
	
	@NotEmpty
	@Column(name = "telephone")
	private String telephone;
	
	@OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Commande> commandes;

	@OneToOne
	@JoinColumn(name = "carte_paiement_default")
	private CartePaiement carteDePaiementDefault;
	
	@OneToOne
	@JoinColumn(name = "adresse_facturation_default")
	private Adresse adresseFacturationDefault;
	
	@OneToOne
	@JoinColumn(name = "adresse_livraison_default")
	private Adresse adresseLivraisonDefault;
	
	@OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<CartePaiement> cartesDePaiement;
	
	@OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Commentaire> commentaires;
	
	@OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ArticlePanier> panier;

	@OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Adresse> adresses;
	
	// Phrase introduction
	@Column(name = "commentaire")
	private String commentaire;
	
	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
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

	public List<Commande> getCommandes() {
		return commandes;
	}

	public List<CartePaiement> getCartesDePaiement() {
		return cartesDePaiement;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public void setCartesDePaiement(List<CartePaiement> cartesDePaiement) {
		this.cartesDePaiement = cartesDePaiement;
	}

	public List<ArticlePanier> getPanier() {
		return panier;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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

	public CartePaiement getCarteDePaiementDefault() {
		return carteDePaiementDefault;
	}

	public void setCarteDePaiementDefault(CartePaiement carteDePaiementDefault) {
		this.carteDePaiementDefault = carteDePaiementDefault;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", profil=" + profil + ", email=" + email + ", telephone=" + telephone + ", commandes=" + commandes
				+ ", commentaire=" + commentaire + "]";
	}

	
}
