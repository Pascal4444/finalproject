package fr.doranco.eboutique.model.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.eboutique.entity.Commentaire;

public interface ICommentaireDao {

	List<Commentaire> getCommentaire() throws SQLException;
	Commentaire getCommentaireById(Integer id) throws SQLException;
	Commentaire addCommentaire(Commentaire cours) throws Exception;
	List<Commentaire> getCommentairebyArticle(Integer id) throws SQLException;
}
