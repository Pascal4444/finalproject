package fr.doranco.eboutique.vue.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.metier.IUserMetier;
import fr.doranco.eboutique.metier.UserMetier;

@ManagedBean(name = "loginBean")
public class LoginBean {

	@ManagedProperty(name = "email", value = "")
	private String email;

	@ManagedProperty(name = "password", value = "")
	private byte[] password;

	@ManagedProperty(name = "errorMessage", value = "")
	private String errorMessage;

	private final IUserMetier utilisateurMetier = new UserMetier();
	
	public LoginBean() {
	}

	public String seConnecter() {
		
		try {
			User utilisateur = (User) utilisateurMetier.seConnecter(email, password);
			if (utilisateur == null) {
				this.errorMessage = "Email et/ou Mot de passe incorrects ! Veuillez réessayer.";
				return "";
			}
			return "achats.xhtml";
		} catch (Exception e) {
			this.errorMessage = "Erreur technique, veuillez réessayer plus tard\n"
					+ "Erreur : " + e;
			return "";
		}
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
