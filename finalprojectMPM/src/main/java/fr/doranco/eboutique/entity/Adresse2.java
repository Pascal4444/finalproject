package fr.doranco.eboutique.entity;

public class Adresse2 {
	
	private String numero;
	
	private String rue;
	
	private String ville;
	private String codePostal;
	private Integer id;
	
	private User user;
	
	public Adresse2() {
	}
	
	public Adresse2(String numero, String rue, String ville, String codePostal) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User utilisateur) {
		this.user = utilisateur;
	}
	
	public int getUserId() {
		return user.getId();
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numero=" + numero + ", rue=" + rue + ", ville=" + ville + ", codePostal="
				+ codePostal + "]";
	}

}
