package fr.project.entity;

import fr.doranco.ecommerce.entity.Commande;


public class LigneDeCommande {

	private Integer id;
	
	private String titreArticle;
	
	private Double prixArticle;
	
	private Double remiseArticle;
	
	private Integer quantite;
	
	private Commande commande;
	
	
	public LigneDeCommande() {
	}

	public LigneDeCommande(String titreArticle, Double prixArticle, Integer quantite, Double remiseArticle) {
		
		this.titreArticle = titreArticle;
		this.prixArticle = prixArticle;
		this.quantite = quantite;
		this.remiseArticle = remiseArticle;
	}
	

	@Override
	public String toString() {
		return "LigneDeCommande [id=" + id + ", titreArticle=" + titreArticle + ", prixArticle=" + prixArticle
				+ ", remiseArticle=" + remiseArticle + ", quantite=" + quantite + ", commande=" + commande + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitreArticle() {
		return titreArticle;
	}

	public void setTitreArticle(String titreArticle) {
		this.titreArticle = titreArticle;
	}

	public Double getPrixArticle() {
		return prixArticle;
	}

	public void setPrixArticle(Double prixArticle) {
		this.prixArticle = prixArticle;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Double getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(Double remiseArticle) {
		this.remiseArticle = remiseArticle;
	}
}
