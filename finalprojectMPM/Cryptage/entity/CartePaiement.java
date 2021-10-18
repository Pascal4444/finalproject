package fr.doranco.pf_cryptage.entity;

import java.util.Date;



public class CartePaiement {

	private Integer id;
	private String numero_carte;
	private Date dateValidite;
	private String cryptogramme;
    private User user_id;
	
	public CartePaiement() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCarte() {
		return numero_carte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numero_carte = numero_carte;
	}

	
	public Date getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String c) {
		this.cryptogramme = cryptogramme;
	}

	

}
