package fr.doranco.eboutique.ws.rest.jersey.server.provider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter<ContainerRequestContext> implements javax.ws.rs.container.ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;
	@Context
	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	@Context
	private static final String AUTHORIZATION_SCHEME = "Basic";

	public void filter(ContainerRequestContext requestContext) throws IOException {
		Method method = resourceInfo.getResourceMethod();
		if (!method.isAnnotationPresent(PermitAll.class)) {
			if (method.isAnnotationPresent(DenyAll.class)) {
				requestContext.abortWith(getAccessForbiddenResponse());
				return;
			}
			final MultivaluedMap<String, String> headers = requestContext.getHeaders();
			final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
			
			if (authorization == null || authorization.isEmpty()) {
				requestContext.abortWith(getAccessForbiddenResponse());
				return;
			}
			final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHORIZATION_SCHEME + " ", "");
			String usernameAndPassword = new String(Base64.getDecoder().decode(encodedUserPassword.getBytes()));
			
			final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
			final String username = tokenizer.nextToken();
			final String password = tokenizer.nextToken();
			
			System.out.println("username : " + username);
			System.out.println("password : " + password);
			
			if (method.isAnnotationPresent(RolesAllowed.class)) {
				RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
				Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
				
				
				if (!isUserAllowed(username, password, rolesSet)) {
					requestContext.abortWith(getAccessForbiddenResponse());
				}
			}
		}

	}

	private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet) {
		boolean isAllowed = false;
		
		if (username.equals("liza") && password.contentEquals("form")) {
			String userRole = "ADMIN";
			if (rolesSet.contains(userRole)) {
				isAllowed = true;
			}
		}
		return isAllowed;
	}

	private Response getAccessForbiddenResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getAuthorizationProperty() {
		return AUTHORIZATION_PROPERTY;
	}

	public static String getAuthorizationScheme() {
		return AUTHORIZATION_SCHEME;
	}

	public ResourceInfo getResourceInfo() {
		return resourceInfo;
	}

	public void setResourceInfo(ResourceInfo resourceInfo) {
		this.resourceInfo = resourceInfo;
	}

}