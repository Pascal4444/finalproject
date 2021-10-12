package fr.project.dao;

import java.sql.SQLException;
import java.util.List;

import fr.project.entity.CartePaiement;

public interface ICartePaiementDao {

	List<CartePaiement> getCartePaiement() throws SQLException;
	CartePaiement getCartePaiementById(Integer id) throws SQLException;
	CartePaiement addCartePaiement(CartePaiement cartePaiement) throws Exception;
}
