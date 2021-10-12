package fr.project.entity;

import java.util.ArrayList;
import java.util.List;

import fr.doranco.ecommerce.entity.Article;

public class Categorie {

	public Categorie() {
		// TODO Auto-generated constructor stub
	}
	private Integer id;
	
	private String nom;
	
	private Integer remise;
	
	private List<Article> articles;
	
	public Categorie() {
		this.articles = new ArrayList<Article>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getRemise() {
		return remise;
	}

	public void setRemise(Integer remise) {
		this.remise = remise;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", remise=" + remise + "]";
	}

}
