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
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "categorie")
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom", length = 30, nullable = false)
	private String nom;
	
	// remise en %
	@Column(name = "remise", length = 3, nullable = true)
	private int remise;
	
	@Column(name = "remiseCumulable", columnDefinition="tinyint(1) default 0" , nullable = true)
	private boolean remiseCumulable;
	
	@NotEmpty
	@Column(name = "description", length = 200, nullable = false)
	private String description;
	
	@Column(name = "photo", nullable = true)
	private String photo;

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

	public int getRemise() {
		return remise;
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public Boolean getRemiseCumulable() {
		return remiseCumulable;
	}

	public void setRemiseCumulable( Boolean remiseCumulable) {
		this.remiseCumulable = remiseCumulable;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Article> getArticles() {
		return articles;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", remise=" + remise + ", remiseCumulable=" + remiseCumulable
				+ ", description=" + description + ", articles=" + articles + "]";
	}
	
	
	
}
