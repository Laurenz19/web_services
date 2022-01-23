package org.stockapp.web_services.resources;

import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;

@Singleton
public class CommentResource {
	
	@GET
	public String test() {
		return "Test works succesfully!";
	}
}
