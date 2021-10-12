package fr.doranco.projetFinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
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

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Adresse() {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
