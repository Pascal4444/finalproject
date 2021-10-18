package fr.doranco.eboutique.model.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.eboutique.entity.Adresse;

public interface IAdresseDao {

	List<Adresse> getAdresse() throws SQLException;
	Adresse getAdresseById(Integer id) throws SQLException;
	Adresse addAdresse(Adresse adresse) throws Exception;
	Adresse getAdresseByUtilisateur(Integer idUtilisateur) throws Exception;
	void updateAdresse(Adresse adresse) throws Exception;
	void removeAdresse(Integer id) throws Exception;
}