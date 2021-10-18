package fr.doranco.eboutique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ligne_commande")
	public class LigneDeCommande {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name = "quantite", length = 100, nullable = false)
	private Integer quantite;
	
	@NotNull
	@Column(name = "prixUnitaire",length = 10, precision = 2, nullable = false)
	private double prixUnitaire;
	
	@Column(name = "remiseArticle",length = 10, precision = 2, nullable = true)
	private double remiseArticle;

	@ManyToOne
	@JoinColumn(name = "commande_id", nullable = false)
	private Commande commande;
	
	@OneToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;


	public LigneDeCommande() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public double getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(double remiseArticle) {
		this.remiseArticle = remiseArticle;
	}
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "LigneDeCommande [id=" + id + ", quantite=" + quantite + ", prixUnitaire=" + prixUnitaire
				+ ", remiseArticle=" + remiseArticle + ", commande=" + commande + ", article=" + article + "]";
	}

	
  
}