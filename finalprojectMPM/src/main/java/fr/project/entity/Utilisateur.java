package fr.project.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import fr.project.utils.Dates;

public class Utilisateur {

	private String [] sqlin = new String[2];
	
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private Date dateNaissance;
	
	private Boolean isActif = null;
	
	
	private String profil;
	
	private String email;
	
	private byte[] password;
	
	private String telephone = "";
	
	private Adresse adressedefault;
	
	private List<Adresse> adresses;
	
	private List<Commande> commandes;
	
	private CartePaiement cartePaiementdefault;
	
	private List<CartePaiement> cartesPaiement;
	
	// On se commente sois-meme
	private String commentaires = "";
	
	public Utilisateur() {
		this.commandes = new ArrayList<Commande>();
		this.adresses = new ArrayList<Adresse>();
		this.cartesPaiement = new ArrayList<CartePaiement>();
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

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean active) {
		this.isActif = active;
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

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public List<CartePaiement> getCartesPaiement() {
		return cartesPaiement;
	}

	public void setCartesPaiement(List<CartePaiement> cartesPaiement) {
		this.cartesPaiement = cartesPaiement;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	
	public Adresse getAdressedefault() {
		return adressedefault;
	}

	public void setAdressedefault(Adresse adressedefault) {
		this.adressedefault = adressedefault;
		if (adresses.contains(adressedefault)) {
		    System.out.println("Adresse existant");
		} else {
		    adresses.add(adressedefault);
		}
	}

	
	public CartePaiement getCartePaiementdefault() {
		return cartePaiementdefault;
	}

	public void setCartePaiementdefault(CartePaiement cartePaiementdefault) {
		this.cartePaiementdefault = cartePaiementdefault;
		if (cartesPaiement.contains(cartePaiementdefault)) {
		    System.out.println("Moyen existant");
		} else {
		    System.out.println("Enregistrement du moyen de payement");
		    cartesPaiement.add(cartePaiementdefault);
		}
	}

	/*public String [] getSql() {
		
		// nom, prenom, date_naissance Obligatoire
		if (nom.isEmpty() || prenom.isEmpty() || dateNaissance == null) {
			System.err.println("nom, prenom ou date vide");
			System.exit(0);
		}else {
			sqlin[0] = "nom, prenom, date_naissance";
			sqlin[1] = getNom()+", "+getPrenom()+", "+Dates.dateUtilToSql(getDateNaissance());
		}
		
		//Optionnel
		if (isActif != null) {
			sqlin[0] = sqlin[0] + ", isactif";
			sqlin[1] = sqlin[1] + ", "+getIsActif();
		}
		
		if(password == null || profil.isEmpty() || email.isEmpty()) {
			System.err.println("profil, email ou password vide");
			System.exit(0);
		}else {
			sqlin[0] = sqlin[0] + ", profil, email, password";
			sqlin[1] = sqlin[1] + ", "+getProfil()+ ", "+getEmail()+ ", "+getPassword();
		}
		
		if (telephone.isEmpty()) {
			
		}else {
			sqlin[0] = sqlin[0] + ", telephone";
			sqlin[1] = sqlin[1] + ", "+getTelephone();
		}
		
		if (adressedefault != null) {
			int addId = adressedefault.getId();
			sqlin[0] = sqlin[0] + ", adresses_default";
			sqlin[1] = sqlin[1] + ", "+addId;
		}
		
		if (cartePaiementdefault != null) {
			int cpId = cartePaiementdefault.getId();
			sqlin[0] = sqlin[0] + ", cartes_de_paiement";
			sqlin[1] = sqlin[1] + ", "+cpId;
		}
		
		if (commentaires.isEmpty()) {
		}else {
			sqlin[0] = sqlin[0] + ", commentaires";
			sqlin[1] = sqlin[1] + ", "+getCommentaires();
		}
		return sqlin;
	}*/
	
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", isActif=" + isActif + ", profil=" + profil + ", email=" + email + ", password="
				+ Arrays.toString(password) + ", telephone=" + telephone + ", adressedefault=" + adressedefault
				+ ", adresses=" + adresses + ", commandes=" + commandes + ", cartePaiementdefault="
				+ cartePaiementdefault + ", cartesPaiement=" + cartesPaiement + ", commentaires=" + commentaires + "]";
	}

	

}
