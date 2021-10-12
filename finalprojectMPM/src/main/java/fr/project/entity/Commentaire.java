package fr.project.entity;

import fr.project.entity.Article;
import fr.project.entity.Utilisateur;

public class Commentaire {

	
	private Integer id;
	
	private String texte;
	
	private Integer note;
	
	private Article article;
	
	private User user;
	
	
	
	public Commentaire() {
		// TODO Auto-generated constructor stub
	}
	public Commentaire(String texte, Integer note) {
		this.texte = texte;
		this.note = note;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return user;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", texte=" + texte + ", note=" + note + "]";
	}

}
