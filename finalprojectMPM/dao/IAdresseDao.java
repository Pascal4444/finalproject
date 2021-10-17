package fr.doranco.eboutique.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import fr.doranco.eboutique.pojo.Adresse;

public interface IAdresseDao {
	   
	List<Adresse> getAdressesByUtilisateurId(Integer id) throws SQLException;
	Adresse addAdresse(Adresse adresse, Integer utilisateurId) throws SQLException;
	void updateAdresse(Integer id) throws Exception;
	void removeAdresse(Integer id) throws Exception;
	void removeAdresses(Integer utilisateurId) throws Exception;
	Set<String> getAllVille(String ville) throws Exception;
	List<fr.doranco.eboutique.entity.Adresse> getAdresse() throws SQLException;
	fr.doranco.eboutique.entity.Adresse getAdresseById(Integer id) throws SQLException;
	fr.doranco.eboutique.entity.Adresse addAdresse
	(fr.doranco.eboutique.entity.Adresse adresse) throws Exception;
}
	
	