package fr.doranco.eboutique.model.dao;

import fr.doranco.eboutique.entity.CartePaiement;
import fr.doranco.eboutique.entity.User;

public interface ICartePaiementDao {

	void addCartePaiement(CartePaiement cp) throws Exception;
	void updateCartePaiement(CartePaiement cp) throws Exception;
	void deleteCartePaiement(Integer id) throws Exception;
	CartePaiement getCartePaiementById(Integer id) throws Exception;
	// @OneToMany _ @OneToOne _ @ManyToOne
	User getUserByCartePaiement(Integer user_id) throws Exception;
}
