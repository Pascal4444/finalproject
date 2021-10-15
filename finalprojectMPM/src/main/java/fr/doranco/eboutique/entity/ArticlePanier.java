package fr.doranco.eboutique.entity;

public class ArticlePanier {


	private Integer id;
	
	private Article article;
	
	private Integer quantite;
	
	private User utilisateur;
	
	public ArticlePanier() {
		
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

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateurr(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	@Override
	public String toString() {
		return "ArticlePanier [id=" + id + ", article=" + article + ", quantite=" + quantite + "]";
	}
}
