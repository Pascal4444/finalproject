package fr.doranco.projetFinal.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name = "numero", length = 11, nullable = false)
	private String Numero;
	
	@NotNull
	@Column(name = "dateCreation", nullable = false)
	private Date dateCreation;

	@NotNull
	@Column(name = "dateLivraison", nullable = false)
	private Date dateLivraison;

	@NotNull
	@Column(name = "totalRemise", nullable = false)
	private String totalRemise;

	@NotNull
	@Column(name = "fraisExpedition", nullable = false)
	private String fraisExpedition;
    
	@NotNull
	@Column(name = "totalGeneral", nullable = false)
	private String totalGeneral;
	
	@NotNull
	@Column(name = "carteDePaiementDefaut", nullable = false)
	private String carteDePaiementDefaut;
		
	OneToOne
	@JoinColumn(name = "adresse-facturation_id", nullable = false)
	private Adresse adresseFacturation;
	
	@OneToOne
	@JoinColumn(name = "adresse-livraison_id", nullable = false)
	private Adresse adresseLivraison;

	@OneToOne
	@JoinColumn(name = "lignesCommande", nullable = false)
	private String lignesCommande;
	
//	private List<LignesCommande> lignesCommandeList;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur;

	public Commande() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(String TotalRemise) {
		this.totalRemise = totalRemise;
	}

	public String getFraisExpedition() {
		return fraisExpedition;
	}

	public void setFraisExpedition(String fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}

	public String getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(String totalGeneral) {
		this.totalGeneral = totalGeneral;
	}
		
	public Adresse getAdresseFacturaion() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adresse AdresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse AdresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public String getCartePaiementDefaut() {
		return carteDePaiementDefaut;
	}

	public void setCartePaiementDefaut(String CartePaiementDefaut) {
		CartePaiementDefaut = CartePaiementDefaut;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public String getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(String LignesCommande) {
		this.lignesCommande = lignesCommande;
	}

}
