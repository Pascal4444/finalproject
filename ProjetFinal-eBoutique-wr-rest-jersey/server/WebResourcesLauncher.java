package fr.doranco.eboutique.ws.rest.jersey.server;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class WebResourcesLauncher {

	private static final URI BASE_URI = URI.create("http://localhost:9991/rest/");

	public static void main(String[] args) {

		try {
			ResourceConfig config = new ResourceConfig();
			config.packages("fr.doranco.wsrest.jersey.webresource");
			ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
			HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, config, locator);
			server.start();
			
			Thread.sleep(2000);
			System.out.println("");
			System.out.println("  -> Serveur Jersey 2 démarré avec succès.");
			System.out.println("  -> Url du contrat : " + BASE_URI + "application.wadl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
