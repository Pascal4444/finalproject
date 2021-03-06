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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	@Column(name = "date_creation", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@NotNull
	@Column(name = "date_livraison", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateLivraison;

	// r?duction en somme
	@NotNull
	@Column(name = "total_remise",length = 10, precision = 2, nullable = false)
	private double totalRemise;

	@NotNull
	@Column(name = "frais_expedition",length = 10, precision = 2, nullable = false)
	private double fraisExpedition;
    
	@NotNull
	@Column(name = "total_general",length = 10, precision = 2, nullable = false)
	private double totalGeneral;
	
	@OneToOne
	@JoinColumn(name = "carte_paiement", nullable = false)
	private CartePaiement carteDePaiement;
		
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

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}
	
	public CartePaiement getCarteDePaiement() {
		return carteDePaiement;
	}

	public void setCarteDePaiement(CartePaiement carteDePaiement) {
		this.carteDePaiement = carteDePaiement;
	}

	@Override
	public String toString() {
		int cartePaiementDefaut = this.carteDePaiement.getId();
		return "Commande [id=" + id + ", numero=" + numero + ", dateCreation=" + dateCreation + ", dateLivraison="
				+ dateLivraison + ", totalRemise=" + totalRemise + ", fraisExpedition=" + fraisExpedition
				+ ", totalGeneral=" + totalGeneral + ", adresseFacturation=" + adresseFacturation
				+ ", adresseLivraison=" + adresseLivraison + ", cartePaiementDefaut=" + cartePaiementDefaut
				+ ", utilisateur=" + utilisateur + ", lignesCommande=" + lignesCommande + "]";
	}

}