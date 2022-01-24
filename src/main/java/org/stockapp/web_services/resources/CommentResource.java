package org.stockapp.web_services.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

public class CommentResource {
	
	@GET
	public String getComments() {
		return "Test works succesfully!";
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId) {
		return String.format("Test works! the messageId value is: %02d & the commentId value is: %02d", messageId, commentId);
	}
}
