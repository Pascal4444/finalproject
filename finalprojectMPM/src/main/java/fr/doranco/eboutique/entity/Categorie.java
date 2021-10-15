package fr.doranco.eboutique.entity;

public class Categorie {
	private Integer id;
	
	private String nom;
	
	private Integer remise;
	
	private Boolean iscumulable;
	
	private String articles;
	
	private String photo;

	
	public Categorie() {
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

	public Integer getRemise() {
		return remise;
	}

	public void setRemise(Integer remise) {
		this.remise = remise;
	}

	public String getArticles() {
		return articles;
	}

	public void setArticles(String articles) {
		this.articles = articles;
	}

	public Boolean getIscumulable() {
		return iscumulable;
	}

	public void setIscumulable(Boolean iscumulable) {
		this.iscumulable = iscumulable;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", remise=" + remise + ", iscumulable=" + iscumulable
				+ ", articles=" + articles + ", photo=" + photo + "]";
	}

	

}
