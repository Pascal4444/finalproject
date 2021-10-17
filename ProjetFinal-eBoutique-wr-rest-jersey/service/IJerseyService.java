package fr.doranco.eboutique.ws.rest.jersey.server.service;

import java.util.List;
import java.net.URISyntaxException;


import javax.ws.rs.core.Response;

import fr.doranco.eboutique.pojo.Utilisateur;


public interface IJerseyService {
	
	final String CHARSET = ";charset=UTF-8";
	
	String getInfo() throws Exception;

	String getDeniedInfos() throws Exception;

	Response getUtilisateurById(Integer id) throws Exception;

	Response getUtilisateurById_MDP(Integer id) throws Exception;

	List<Utilisateur> getUtilisateurs() throws Exception;

	Utilisateur getAllUtilisateurs() throws Exception;
	
	Response addUtilisateur(Utilisateur utilisateur) throws URISyntaxException;
	
	Response updateUtilisateur(Utilisateur utilisateur) throws URISyntaxException;
	
	Response removeUtilisateurById(Integer id) throws URISyntaxException;

}
