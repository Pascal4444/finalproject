package fr.project.dao;

import java.sql.SQLException;
import java.util.List;

import fr.project.entity.Adresse;

public interface IAdresseDao {

	List<Adresse> getAdresse() throws SQLException;
	Adresse getAdresseById(Integer id) throws SQLException;
	Adresse addAdresse(Adresse adresse) throws Exception;
}
