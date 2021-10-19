package fr.doranco.eboutique.model.dao;

import fr.doranco.eboutique.entity.Params;

public interface IParamsDao {

	void addParams(Params params) throws Exception;
	void updateParams(Params params) throws Exception;
	void deleteParams(Integer id) throws Exception;
	Params getParamsById(Integer id) throws Exception;
	// @OneToMany _ @OneToOne _ @ManyToOne
}
