package fr.doranco.eboutique.vue.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.doranco.eboutique.entity.User;
import fr.doranco.eboutique.metier.IUserMetier;
import fr.doranco.eboutique.metier.UserMetier;

@ManagedBean(name = "utilisateurBean")
@SessionScoped
public class GestionArticleBean {

	private String email;
	private byte[] password;
	
	private final IUserMetier utilisateurMetier = new UserMetier();
	private String errorMessage;
	
	public GestionArticleBean() {
	}

	public String seConnecter() {
		
		try {
			User utilisateur = (User) utilisateurMetier.seConnecter(email, password);
			if (utilisateur == null) {
				this.errorMessage = "Email et/ou Mot de passe incorrects ! Veuillez réessayer.";
				return "";
			}
			return "article.xhtml";
		} catch (Exception e) {
			this.errorMessage = "Erreur technique, veuillez réessayer plus tard\n"
					+ "Erreur : " + e;
			return "";
		}
	}
	
	public List<String> getProfils() {
		return new ArrayList<String>(Arrays.asList("", "Client", "Magasinier", "Admin"));
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
