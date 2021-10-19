package fr.doranco.eboutique.model.dao;

import fr.doranco.eboutique.entity.Commentaire;
import fr.doranco.eboutique.entity.User;

public interface ICommentaireDao {

	void addCommentaire(Commentaire commentaire) throws Exception;
	void updateCommentaire(Commentaire commentaire) throws Exception;
	void deleteCommentaire(Integer id) throws Exception;
	Commentaire getCommentaireById(Integer id) throws Exception;
	// @OneToMany _ @OneToOne _ @ManyToOne
	Commentaire getArticleByCommentaire(Integer article_id) throws Exception;
	User getUserByCommentaire(Integer user_id) throws Exception;
}
