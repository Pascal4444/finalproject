package fr.doranco.eboutique.ws.rest.jersey.server.service;

import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.doranco.eboutique.entity.Utilisateur;
import fr.doranco.eboutique.model.dao.IUtilisateurDao;
import fr.doranco.eboutique.model.dao.UtilisateurDao;


@Path("/utilisateurs")
public class JerseyService implements IJerseyService {
// Création de la variable employeDao
	private final static IUtilisateurDao utilisateurDao = new UtilisateurDao();

	@PermitAll
	@Produces(MediaType.TEXT_PLAIN + CHARSET)
	@Path("infos")
	@GET
	@Override
	public String getInfo() throws Exception {

		return " Hello from Boutique Fil Rouge, these are General infos.";
	}

	@DenyAll
	@Produces(MediaType.TEXT_PLAIN + CHARSET)
	@Path("denied-infos")
	@GET
	@Override
	public String getDeniedInfos() throws Exception {

		return " Hello from Boutique Fil Rouge, these are not authorized infos.";
	}

	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	@Path("get-{id}")
	@GET
	@Override
	public Response getUtilisateurById(@PathParam("id") Integer id) throws Exception {

		return null;
	}

	@RolesAllowed({ "ADMIN", "CLIENT" })
	@Produces(MediaType.APPLICATION_JSON)
	@Path("get-mdp-{id}")
	@GET
	@Override
	public Response getUtilisateurById_MDP(@PathParam("id") Integer id) throws Exception {

		return null;
	}

	@RolesAllowed({ "ADMIN", "CLIENT" })
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAll")
	@GET
	@Override
	public List<Utilisateur> getUtilisateurs() throws Exception {

		return utilisateurDao.getUtilisateurs();
	}

	@RolesAllowed({ "ADMIN", "CLIENT" })
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllInOne")
	@GET
	@Override
	public Utilisateur getAllUtilisateurs() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@RolesAllowed("ADMIN")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("post")
	@POST
	@Override
	public Response addUtilisateur(Utilisateur utilisateur) throws URISyntaxException {

		return null;
	}

	@RolesAllowed("ADMIN")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("put")
	@PUT
	@Override
	public Response updateUtilisateur(Utilisateur utilisateur) throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@RolesAllowed("ADMIN")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete-{id}")
	@DELETE
	@Override
	public Response removeUtilisateurById(@PathParam("id")Integer id) throws URISyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

}
