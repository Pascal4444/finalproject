package fr.doranco.eboutique.entity;

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
public class Commande<ligneDeCommande, lignesCommande> {

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

	@NotNull
	@Column(name = "totalRemise", nullable = false)
	private Float totalRemise;

	@NotNull
	@Column(name = "fraisExpedition", nullable = false)
	private Float fraisExpedition;
    
	@NotNull
	@Column(name = "totalGeneral", nullable = false)
	private Float totalGeneral;
	
	@NotNull
	@Column(name = "carteDePaiementDefaut", nullable = false)
	private CartePaiement carteDePaiementDefaut;
		
	@OneToOne
	@JoinColumn(name = "adresse-facturation_id", nullable = false)
	private Adresse adresseFacturation;
	
	@OneToOne
	@JoinColumn(name = "adresse-livraison_id", nullable = false)
	private Adresse adresseLivraison;

	@OneToOne
	@JoinColumn(name = "lignesCommande", nullable = false)
	private List<ligneDeCommande> lignesCommande;
	
//	private List<LignesCommande> lignesCommandeList;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
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

	public Float getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(Float totalRemise) {
		this.totalRemise = totalRemise;
	}

	public Float getFraisExpedition() {
		return fraisExpedition;
	}

	public void setFraisExpedition(Float fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}

	public Float getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(Float totalGeneral) {
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
	
	public List<ligneDeCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<ligneDeCommande> lignesCommande) {
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