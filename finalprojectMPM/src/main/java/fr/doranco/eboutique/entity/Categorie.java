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
@Table(name = "categorie")
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom", length = 30, nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "remise", length = 10, nullable = false)
	private String remise;
	
	@NotEmpty
	@Column(name = "remiseCumulable", length = 10, nullable = false)
	private String remiseCumulable;
	
	@NotEmpty
	@Column(name = "description", length = 200, nullable = false)
	private String description;
	
	@Column(name = "photo", nullable = true)
	private byte[] photo;

	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Article> articles;

	public Categorie() {
		this.articles = new ArrayList<Article>();
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

	public String getRemise() {
		return remise;
	}

	public void setRemise(String remise) {
		this.remise = remise;
	}

	public String getRemiseCumulable() {
		return remiseCumulable;
	}

	public void setRemiseCumulable(String remiseCumulable) {
		this.remiseCumulable = remiseCumulable;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public List<Article> getArticles() {
		return articles;
	}
	
}
