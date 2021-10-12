package fr.doranco.projetFinal.entity;

import java.util.Date;
import java.util.List;

public class Utilisateur {

	private Integer id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String profil;
	private String email;
	private String password;
	private String telephone;
	private String adresses;
	private String commandes;
	private String cartesDePaiement;
	private String commentaires;
	private List<ArticlePanier> panier;
	
	public Utilisateur() {
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getAdresses() {
		return adresses;
	}

	public void setAdresses(String adresses) {
		this.adresses = adresses;
	}
	
	public String getCommandes() {
		return commandes;
	}

	public void setCommandes(String commandes) {
		this.commandes = commandes;
	}
	
	public String getCartesDePaiement() {
		return cartesDePaiement;
	}

	public void setCartesDePaiement(String cartesDePaiement) {
		this.cartesDePaiement = cartesDePaiement;
	}
	
	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
		
	public List<ArticlePanier> getPanier() {
		return panier;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", email=" + email + ", password=" + password + ", profil=" + profil + " telephone=" + telephone
				+ ", adresses=" + adresses + ", commandes=" + commandes + ", cartesDePaiement=" + cartesDePaiement
				+ ", commentaires=" + commentaires + ", panier=" + panier + ",]";
	}
		
	@Entity
	@Table(name = "utilisateur")
	public class Utilisateur 
	
		@Id
		@Generated(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@NotEmpty
		@Column(name = "nom", length = 25, nullable = false)
		private String nom;
		
		@NotEmpty
		@Column(name = "prenom", length = 25, nullable = false)
		private String prenom;
		
		@NotNull
		@Column(name = "dateNaissance", nullable = false)
		@Temporal(TemporalType.DATE)
		private Date dateNaissance;
		
		@NotEmpty
		@Column(name = "profil", length = 25, nullable = false)
		private String profil;
		
		@NotEmpty
		@Column(name = "email", length = 45, nullable = false)
		private String email;
		
		@NotEmpty
		@Column(name = "password", length = 20, nullable = false)
		private String password;
			
		@NotEmpty
		@Column(name = "telephone", length = 25, nullable = false)
		private String telephone;
					
		@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		private List<Adresse> adresses;
		
		@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<Commandes> commandes;
		
		@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<CartesDePaiement> cartesDePaiement ;
		
		@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<Commentaires> commentaires;
		
		@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<ArticlePanier> panier;

		public Utilisateur() {
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

		public void setNom(String Nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String Prenom) {
			this.prenom = prenom;
		}

		public String getCartesDePaiement() {
			return cartesDePaiement;
		}
		
		public void setCartesDePaiement(String CartesDePaiement) {
			this.cartesDePaiement = cartesDePaiement;
		}
		
		public List<Adresse> getAdresses() {
			return adresses;
		}

		public List<Commandes> getCommandes() {
			return commandes;
		}

		public List<ArticlePanier> getPanier() {
			return panier;
		}
		
		
	}
	
}
