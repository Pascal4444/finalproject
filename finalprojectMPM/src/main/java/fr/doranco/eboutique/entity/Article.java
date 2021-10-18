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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "article")
@NamedQueries({
	@NamedQuery(name = "Article:findByCategorieId",
			query = "FROM Article a WHERE a.categorie.id = :id"),
	@NamedQuery(name = "Article:findByCategorieName",
	query = "FROM Article a WHERE a.categorie.nom = :nom")
})
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom", length = 30, nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "description", length = 500, nullable = false)
	private String description;
	
	@Column(name = "prix",length = 10, precision = 2, nullable = false)
	private double prix;
	
	@Column(name = "remise",length = 10, precision = 2, nullable = false)
	private double remise;
	
	@NotEmpty
	@Column(name = "stock", nullable = false)
	private String stock;
	
	@Column(name = "isVendable", columnDefinition="tinyint(1) default 1")
	private boolean isVendable;
	
	@NotEmpty
	@Column(name = "photo", nullable = true)
	private String photo;

	@Column(name = "video", nullable = true)
	private String video;
	
	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Commentaire> commentaires;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Categorie categorie;
	
	public Article() {
		commentaires = new ArrayList<Commentaire>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
	
	public Boolean getIsVendable() {
		return isVendable;
	}

	public void setIsVendable(Boolean isVendable) {
		this.isVendable = isVendable;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", prix="
				+ prix + ", remise=" + remise + ", stock=" + stock + ", isVendable=" + isVendable + "]";
	}
	
}
