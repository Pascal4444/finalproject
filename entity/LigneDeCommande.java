package fr.doranco.projetFinal.entity;

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
@Table(name = "ligneDeCommande")
public class LigneDeCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name = "quantite", length = 100, nullable = false)
	private String quantite;
	
	@NotEmpty
	@Column(name = "prixUnitaire", length = 200, nullable = false)
	private String prixUnitaire;
	
	@Column(name = "remiseArticle", nullable = false)
	private String remiseArticle;

	@NotEmpty
	@Column(name = "commande", nullable = false)
	private String commande;
	
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

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(String prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(String remiseArticle) {
		this.remiseArticle = remiseArticle;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public String getCommande() {
		return commande;
	}

	public void setCommande(String commande) {
		this.commande = commande;
	}
	
	
}
