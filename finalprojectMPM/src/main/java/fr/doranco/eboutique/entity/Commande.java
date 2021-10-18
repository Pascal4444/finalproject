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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name = "numero", length = 11, nullable = false)
	private String numero;
	
	@NotNull
	@Column(name = "dateCreation", nullable = false)
	private Date dateCreation;

	@NotNull
	@Column(name = "dateLivraison", nullable = false)
	private Date dateLivraison;

	// réduction en somme
	@NotNull
	@Column(name = "totalRemise", nullable = false)
	private double totalRemise;

	@NotNull
	@Column(name = "fraisExpedition", nullable = false)
	private double fraisExpedition;
    
	@NotNull
	@Column(name = "totalGeneral", nullable = false)
	private double totalGeneral;
	
	@NotNull
	@OneToOne
	@Column(name = "carteDePaiementDefaut", nullable = false)
	private CartePaiement carteDePaiementDefaut;
		
	@OneToOne
	@JoinColumn(name = "adresse_facturation", nullable = false)
	private Adresse adresseFacturation;
	
	@OneToOne
	@JoinColumn(name = "adresse_livraison", nullable = false)
	private Adresse adresseLivraison;

	@OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LigneDeCommande> lignesCommande;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User utilisateur;

	
	public Commande() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public @NotNull double getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(double totalRemise) {
		this.totalRemise = totalRemise;
	}

	public @NotNull double getFraisExpedition() {
		return fraisExpedition;
	}

	public void setFraisExpedition(double fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}

	public @NotNull double getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(double totalGeneral) {
		this.totalGeneral = totalGeneral;
	}
		
	public Adresse getAdresseFacturaion() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public CartePaiement getCartePaiementDefaut() {
		return carteDePaiementDefaut;
	}

	public void setCartePaiementDefaut(CartePaiement cartePaiementDefaut) {
		this.carteDePaiementDefaut = cartePaiementDefaut;
	}
	
	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public List<LigneDeCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneDeCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	
	public CartePaiement getCarteDePaiementDefaut() {
		return carteDePaiementDefaut;
	}

	public void setCarteDePaiementDefaut(CartePaiement carteDePaiementDefaut) {
		this.carteDePaiementDefaut = carteDePaiementDefaut;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	@Override
	public String toString() {
		int cartePaiementDefaut = this.carteDePaiementDefaut.getId();
		return "Commande [id=" + id + ", numero=" + numero + ", dateCreation=" + dateCreation + ", dateLivraison="
				+ dateLivraison + ", totalRemise=" + totalRemise + ", fraisExpedition=" + fraisExpedition
				+ ", totalGeneral=" + totalGeneral + ", adresseFacturation=" + adresseFacturation
				+ ", adresseLivraison=" + adresseLivraison + ", cartePaiementDefaut=" + cartePaiementDefaut
				+ ", utilisateur=" + utilisateur + ", lignesCommande=" + lignesCommande + "]";
	}

}