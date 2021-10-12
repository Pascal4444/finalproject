package fr.doranco.projetFinal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cartePaiement")
public class CartePaiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotEmpty
	@Column(name = "numero", length = 11, nullable = false)
	private String numero;
	
	/**
	 * C'est le Titulaire de la carte de paiement
	 */
	@NotEmpty
	@Column(name = "nomProprietaire", length = 45, nullable = false)
	private String nomProprietaire;
	
	@NotEmpty
	@Column(name = "prenomProprietaire", length = 100, nullable = false)
	private String prenomProprietaire;
	
	@NotNull
	@Column(name = "dateFinValidite", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateFinValidite;
	
	@NotEmpty
	@Column(name = "codeCryptogramme", length = 10, nullable = false)
	private String codeCryptogramme;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur;

	public CartePaiement() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getPrenomProprietaire() {
		return prenomProprietaire;
	}

	public void setPrenomProprietaire(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}
	
	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite= dateFinValidite;
	}

	public String getCodeCryptogramme() {
		return codeCryptogramme;
	}

	public void setCodeCryptogramme(String codeCryptogramme) {
		this.codeCryptogramme = codeCryptogramme;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
