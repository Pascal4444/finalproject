package fr.project.entity;


public class LigneDeCommande {

	private Integer id;
	
	private Double prixArticle;
	
	private Double remiseArticle;
	
	private Integer quantite;
	
	private Commande commande;
	
	private Article article;
	
	public LigneDeCommande() {
	}

	public LigneDeCommande(Double prixArticle, Integer quantite, Double remiseArticle) {
		
		this.prixArticle = prixArticle;
		this.quantite = quantite;
		this.remiseArticle = remiseArticle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
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

	@Override
	public String toString() {
		return "LigneDeCommande [id=" + id + ", prixArticle=" + prixArticle + ", remiseArticle=" + remiseArticle
				+ ", quantite=" + quantite + ", commande=" + commande + ", article=" + article + "]";
	}
	
	
}
