package fr.doranco.eboutique.vue.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.eboutique.pojo.Utilisateur;
import fr.doranco.eboutique.metier.IUtilisateurMetier;
import fr.doranco.eboutique.metier.UtilisateurMetier;

@ManagedBean(name = "loginBean")
public class LoginBean {

	@ManagedProperty(name = "email", value = "")
	private String email;

	@ManagedProperty(name = "password", value = "")
	private String password;

	@ManagedProperty(name = "errorMessage", value = "")
	private String errorMessage;

	private final IUtilisateurMetier utilisateurMetier = new UtilisateurMetier();
	
	public LoginBean() {
	}

	public String seConnecter() {
		
		try {
			Utilisateur utilisateur = (Utilisateur) utilisateurMetier.seConnecter(email, password);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
