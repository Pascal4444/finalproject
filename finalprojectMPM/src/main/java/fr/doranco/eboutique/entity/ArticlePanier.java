package fr.doranco.eboutique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
// import javax.persistence.ManyToOne;
// import javax.persistence.OneToOne;

@Entity
@Table(name = "articlePanier")
public class ArticlePanier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 **    relation Bidirectionnelle    **
	**/
	
	@NotNull
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;
	
	@NotEmpty
	@Column(name = "quantite", length = 45, nullable = false)
	private Integer quantite;
	
	@NotEmpty
	@Column(name = "utilisateur", nullable = false)
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

	public void setUtilisateur(User utilisateur) {
		this.utilisateur= utilisateur;
	}

	public ArticlePanier(Integer id, Article article, Integer quantite, User utilisateur) {
		this.id = id;
		this.article = article;
		this.quantite = quantite;
		this.utilisateur = utilisateur;
	}
	
	@Override
	public String toString() {
		return "ArticlePanier [id=" + id + ", article=" + article + ", quantite=" + quantite + ", utilisateur="
				+ utilisateur + "]";
	}

}
