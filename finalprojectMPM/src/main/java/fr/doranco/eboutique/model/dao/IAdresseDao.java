package fr.doranco.eboutique.model.dao;

import fr.doranco.eboutique.entity.Adresse;
import fr.doranco.eboutique.entity.User;

public interface IAdresseDao {

	void addAdresse(Adresse adresse) throws Exception;
	void updateAdresse(Adresse adresse) throws Exception;
	void deleteAdresse(Integer id) throws Exception;
	Adresse getAdresseById(Integer id) throws Exception;
	// @OneToMany _ @OneToOne _ @ManyToOne
	User getUserByAdresse(Integer user_id) throws Exception;
}