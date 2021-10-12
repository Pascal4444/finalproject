package fr.project.dao;

import java.sql.SQLException;
import java.util.List;

import fr.project.entity.Commentaire;

public interface ICommentaireDao {

	List<Commentaire> getCommentaire() throws SQLException;
	Commentaire getCommentaireById(Integer id) throws SQLException;
	Commentaire addCommentaire(Commentaire cours) throws Exception;
}
