package fr.doranco.eboutique.model.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.eboutique.entity.Params;



public interface IParamsDao {

	List<Params> getParams() throws SQLException;
	Params getParamsById(Integer id) throws SQLException;
	Params addParams(Params params) throws Exception;
}
