package fr.doranco.eboutique.entity;

public class Commentaire2 {

	
	private Integer id;
	
	private String texte;
	
	private Integer note;
	
	private Article article;
	
	private User utilisateur;
	
	public Commentaire2() {
	}
	
	public Commentaire2(String texte, Integer note) {
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

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", texte=" + texte + ", note=" + note + "]";
	}

}
