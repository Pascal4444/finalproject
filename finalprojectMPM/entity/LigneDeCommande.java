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


	public class LigneDeCommande {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name = "quantite", length = 100, nullable = false)
	private Integer quantite;
	
	@NotEmpty
	@Column(name = "prixUnitaire", length = 200, nullable = false)
	private Float prixUnitaire;
	
	@Column(name = "remiseArticle", nullable = false)
	private Float remiseArticle;

	@NotEmpty
	@Column(name = "commande", nullable = false)
	private Commande commande;
	
	@Column(name = "article", nullable = false)
	private List<Article> article;
	
	@OneToMany(mappedBy = "ligneDeCommande", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Article> articles;


	public LigneDeCommande() {
		this.articles = new ArrayList<Article>();
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

	public Float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Float getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(Float remiseArticle) {
		this.remiseArticle = remiseArticle;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
		
	
	@Override
	public String toString() {
		return "LigneDeCommande [id=" + id + ", quantite=" + quantite + ", prixUnitaire=" + prixUnitaire
				+ ", remiseArticle=" + remiseArticle + ", commande=" + commande + "]";
	}
  
}