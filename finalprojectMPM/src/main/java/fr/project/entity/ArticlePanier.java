package fr.project.entity;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.User;

public class ArticlePanier {

	public ArticlePanier() {
		// TODO Auto-generated constructor stub
	}

	private Integer id;
	
	private Article article;
	
	private Integer quantite;
	
	private User user;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "ArticlePanier [id=" + id + ", article=" + article + ", quantite=" + quantite + "]";
	}
}
