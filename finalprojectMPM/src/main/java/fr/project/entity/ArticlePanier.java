package fr.project.entity;

import fr.project.entity.Article;
import fr.project.entity.Utilisateur;

public class ArticlePanier {


	private Integer id;
	
	private Article article;
	
	private Integer quantite;
	
	private Utilisateur utilisateur;
	
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateurr(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	@Override
	public String toString() {
		return "ArticlePanier [id=" + id + ", article=" + article + ", quantite=" + quantite + "]";
	}
}
