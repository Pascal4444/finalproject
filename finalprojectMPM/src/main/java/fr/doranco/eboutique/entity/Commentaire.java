package fr.doranco.eboutique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "commentaire")
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name = "texte", length = 200, nullable = false)
	private String texte;
	
	@NotEmpty
	@Column(name = "note", length = 1, nullable = false)
	private Integer note;
	
	@ManyToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User utilisateur;


	public Commentaire() {
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
	
	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", texte=" + texte + ", note=" + note + ", article=" + article
				+ ", utilisateur=" + utilisateur + "]";
	}
	
}
