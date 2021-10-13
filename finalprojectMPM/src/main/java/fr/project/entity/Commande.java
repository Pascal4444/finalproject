package fr.project.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {

	private Integer id;
	
	private String numero;
	
	private Date dateCommande;
	
	private Date dateLivraison;
	
	private Double totalRemise;
	
	private Double fraisExpedition;
	
	private Double total_general;
	
	private Integer adresseFacturation;
	
	private Integer adresseLivraison;
	
	private Integer cartePaiementDefaut;
	
	private Utilisateur utilisateur;
	
	private List<LigneDeCommande> lignesDeCommande;

	public Commande() {
		this.lignesDeCommande = new ArrayList<LigneDeCommande>();
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

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Double getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(Double totalRemise) {
		this.totalRemise = totalRemise;
	}

	public Double getFraisExpedition() {
		return fraisExpedition;
	}

	public void setFraisExpedition(Double fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}

	public Double getTotal_general() {
		return total_general;
	}

	public void setTotal_general(Double total_general) {
		this.total_general = total_general;
	}

	public Integer getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Integer adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public Integer getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Integer adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public Integer getCartePaiementDefaut() {
		return cartePaiementDefaut;
	}

	public void setCartePaiementDefaut(Integer cartePaiementDefaut) {
		this.cartePaiementDefaut = cartePaiementDefaut;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<LigneDeCommande> getLignesDeCommande() {
		return lignesDeCommande;
	}

	public void setLignesDeCommande(List<LigneDeCommande> lignesDeCommande) {
		this.lignesDeCommande = lignesDeCommande;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCommande=" + dateCommande + ", dateLivraison="
				+ dateLivraison + ", totalRemise=" + totalRemise + ", fraisExpedition=" + fraisExpedition
				+ ", total_general=" + total_general + ", adresseFacturation=" + adresseFacturation
				+ ", adresseLivraison=" + adresseLivraison + ", cartePaiementDefaut=" + cartePaiementDefaut + ", ="
				+ utilisateur + ", lignesDeCommande=" + lignesDeCommande + "]";
	}
	

}
