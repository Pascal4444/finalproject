package fr.doranco.eboutique.entity;

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
// import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "cartePaiement")
public class CartePaiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	/**
	 * C'est le Titulaire de la carte de paiement
	 **/
	@NotEmpty
	@Column(name = "nomProprietaire", length = 45, nullable = false)
	private String nomProprietaire;
	
	@NotEmpty
	@Column(name = "prenomProprietaire", length = 100, nullable = false)
	private String prenomProprietaire;
	
	@NotEmpty
	@Column(name = "numero", length = 11, nullable = false)
	private Byte[] numero;
	
	@NotEmpty
	@Column(name = "dateFinValidite", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateFinValidite;
	
	@NotEmpty
	@Column(name = "cryptogramme", length = 10, nullable = false)
	private Byte[] cryptogramme;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur", nullable = false)
	private User utilisateur;

	public CartePaiement() {
	}
	
	public CartePaiement(Integer id, String nomProprietaire, String prenomProprietaire, @NotEmpty Byte[] numero,
			Date dateFinValidite, @NotEmpty Byte[] cryptogramme, User utilisateur) {
		this.id = id;
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.numero = numero;
		this.dateFinValidite = dateFinValidite;
		this.cryptogramme = cryptogramme;
		this.utilisateur = utilisateur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public @NotEmpty Byte[] getNumero() {
		return numero;
	}

	public void setNumero(@NotEmpty Byte[] numero) {
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

	public @NotEmpty Byte[] getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(@NotEmpty Byte[] cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	@Override
	public String toString() {
		return "CartePaiement [id=" + id + ", nomProprietaire=" + nomProprietaire + ", prenomProprietaire="
				+ prenomProprietaire + ", numero=" + numero + ", dateFinValidite=" + dateFinValidite + "]";
	}
}