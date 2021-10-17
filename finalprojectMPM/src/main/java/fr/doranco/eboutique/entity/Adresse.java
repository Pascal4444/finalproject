package fr.doranco.eboutique.entity;

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

@Entity
@Table(name = "adresse")
@NamedQueries({
@NamedQuery(name ="Address:findAddressesByUserId",
query = "FROM Address a WHERE a.user.id = :id")
})

public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name = "numero", length = 4, nullable = false)
	private String numero;
	
	@NotEmpty
	@Column(name = "rue", length = 45, nullable = false)
	private String rue;
	
	@NotEmpty
	@Column(name = "codePostal", length = 5, nullable = false)
	private String codePostal;
	
	@NotEmpty
	@Column(name = "ville", length = 25, nullable = false)
	private String ville;

	private User utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private int user_id = utilisateur.getId();
	

	public Adresse() {}

	public Adresse(String numero, String rue, String ville, String codePostal) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numero=" + numero + ", rue=" + rue + ", ville=" + ville + ", codePostal="
				+ codePostal + ", utilisateur=" + utilisateur + "]";
	}

}