package org.stockapp.web_services.resources;


/*import java.util.List;

import org.stockapp.web_services.model.Comment;*/
import org.stockapp.web_services.model.Message;
import org.stockapp.web_services.services.CommentService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService commentService = new CommentService();
	
	@GET
	public Message getComments(@PathParam("messageId") Long id) {
		return commentService.getAllComments(id);
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId) {
		return String.format("Test works! the messageId value is: %02d & the commentId value is: %02d", messageId, commentId);
	}
}
