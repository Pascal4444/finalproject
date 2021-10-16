package fr.doranco.eboutique.ws.rest.jersey.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.doranco.wsrest.jersey.entity.Employe;

public class GetAllJson {

	private final static String CHARSET = ";charset=UTF-8";
	
	public static void main(String[] args) {
		
		ClientConfig config = new ClientConfig();
		config.register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget webTarget = client.target("http://localhost:9991/rest")
									.path("employes")
									.path("all");
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON + CHARSET)
				.header("content-type", MediaType.APPLICATION_JSON + CHARSET)
				.header("societe", "Doranco")
				.accept(MediaType.APPLICATION_JSON + CHARSET);
		
		Response response = builder.get();
		if (response.getStatus() == 200) {
			List<Employe> employes = response.readEntity(new GenericType<List<Employe>>() {});
			employes.forEach(e -> System.out.println(e));
		} else {
			System.out.println(response.getStatus());
			System.out.println(response.readEntity(String.class));
		}
		System.exit(0);
				
	}
}
