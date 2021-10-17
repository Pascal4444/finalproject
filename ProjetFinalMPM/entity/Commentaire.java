package fr.doranco.eboutique.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

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
	
	@Column(name = "article", nullable = true)
	private List<Article> article;

	@NotEmpty
	@Column(name = "utilisateur", nullable = false)
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "commentaire", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Article> articles;


	public Commentaire() {
		this.articles = new ArrayList<Article>();
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

	public List<Article> getArticles() {
		return articles;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", texte=" + texte + ", note=" + note + ", article=" + article
				+ ", utilisateur=" + utilisateur + "]";
	}
	
}
