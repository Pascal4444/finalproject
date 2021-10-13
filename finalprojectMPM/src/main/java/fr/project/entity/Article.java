package fr.project.entity;

import java.util.ArrayList;
import java.util.List;

public class Article {

	private Integer id;
	
	private String nom;
	
	private String description;
	
	private Double prix;
	
	private Integer remise;
	
	private Integer stock;
	
	private Boolean isVendable;
	
	private String photos;
	
	private String videos;
	
	private List<Commentaire> commentaires;
	
	private Categorie categorie;
	
	public Article() {
		this.commentaires = new ArrayList<Commentaire>();
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

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getRemise() {
		return remise;
	}

	public void setRemise(Integer remise) {
		this.remise = remise;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Boolean getIsVendable() {
		return isVendable;
	}

	public void setIsVendable(Boolean isVendable) {
		this.isVendable = isVendable;
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
	
	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getVideos() {
		return videos;
	}

	public void setVideos(String videos) {
		this.videos = videos;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", remise="
				+ remise + ", stock=" + stock + ", isVendable=" + isVendable + "]";
	}
	
	
}
