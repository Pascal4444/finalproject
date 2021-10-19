package fr.doranco.eboutique.model.dao;

import fr.doranco.eboutique.entity.Article;
import fr.doranco.eboutique.entity.Commande;
import fr.doranco.eboutique.entity.LigneDeCommande;

public interface ILigneDeCommandeDao {

	void addLigneDeCommande(LigneDeCommande ldc) throws Exception;
	void updateLigneDeCommande(LigneDeCommande ldc) throws Exception;
	void deleteLigneDeCommande(Integer id) throws Exception;
	LigneDeCommande getLigneDeCommandeById(Integer id) throws Exception;
	// @OneToMany _ @OneToOne _ @ManyToOne
	Commande getCommandeByLigneDeCommande(Integer commande_id) throws Exception;
	Article getArticleByLigneDeCommande(Integer article_id) throws Exception;
}
