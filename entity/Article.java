package fr.doranco.projetFinal.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import fr.doranco.projetFinal.entity.Categorie;

@Entity
@Table(name = "article")
@NamedQueries({
	@NamedQuery(name = "Article:findByCategoryId",
			query = "FROM Article a WHERE a.category.id = :id"),
	@NamedQuery(name = "Article:findByCategoryName",
	query = "FROM Article a WHERE a.category.name = :name")
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
	
	@Column(name = "prix", nullable = false)
	private Float prix;
	
	@Column(name = "remise", length = 2, nullable = false)
	private Integer remise;
	
	@Column(name = "stock", nullable = false)
	private String stock;
	
	@Column(name = "ruptureStock", nullable = false)
	private String ruptureStock;
	
	
	@Column(name = "photo", nullable = true)
	private byte[] photo;

	@Column(name = "video", nullable = true)
	private byte[] video;
	
	@ManyToOne
	@JoinColumn(name = "categorie_id", nullable = false)
	private Categorie categorie;
	
	public Article() {
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

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Integer getRemise() {
		return remise;
	}

	public void setRemise(Integer remise) {
		this.remise = remise;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
	
	public String getRuptureStock() {
		return ruptureStock;
	}

	public void setRuptureStock(String ruptureStock) {
		this.ruptureStock = ruptureStock;
	}
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}
	

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", prix="
				+ prix + ", remise=" + remise + ", stock=" + stock + ", ruptureSock=" + ruptureStock + ", photo=" + Arrays.toString(photo)
				+ ", video=" + Arrays.toString(video) + "]";
	}
	
}
