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
import javax.persistence.OneToMany;
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
	@Column(name = "nom")
	private String nom;

	@NotEmpty
	@Column(name = "prenom")
	private String prenom;

	@NotNull
	@Column(name = "date_naissance")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Column(name = "isactif")
	private Boolean isActif;
	
	@NotNull
	@Column(name = "profil")
	private String profil;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "password")
	private byte[] password;
	
	@Column(name = "telephone")
	private String telephone;
	
	
	@OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Commande> commandes;

	@OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<CartePaiement> cartesDePaiement;
	
	@OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Commentaire> listcommentaires;
	
	@OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ArticlePanier> panier;

	@OneToMany(mappedBy = "utilisateur", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Adresse> adresses;
	
	// Phrase introduction
	@Column(name = "commentaires")
	private String commentaires;
	
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

	public List<Commentaire> getListcommentaires() {
		return listcommentaires;
	}

	public void setListcommentaires(List<Commentaire> listcommentaires) {
		this.listcommentaires = listcommentaires;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
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
	

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", isActif=" + isActif + ", profil=" + profil + ", email=" + email + ", password=" + password
				+ ", telephone=" + telephone + "]";
	}
	
}
