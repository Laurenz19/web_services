package org.stockapp.web_services.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.stockapp.web_services.database.Database;
import org.stockapp.web_services.model.Comment;
import org.stockapp.web_services.model.ErrorMessage;
import org.stockapp.web_services.model.Message;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class CommentService {
	
	private Map<Long, Message> messages = Database.getMessages();
	
	public List<Comment> getAllComments(Long messageId){
		ErrorMessage er1 = new ErrorMessage(404, "The message with id: "+ messageId +" is not found");
		Message message = messages.get(messageId);
		
		if(message == null) {
			Response res = Response.status(Status.NOT_FOUND).entity(er1).build();
			throw new WebApplicationException(res);
		}
		Map<Long, Comment> comments = message.getComments();
		
	
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(Long messageId, Long commentId) {
		ErrorMessage er1 = new ErrorMessage(404, "The message with id: "+ messageId +" is not found");
		ErrorMessage er2 = new ErrorMessage(404, "The comment with id: "+ commentId +" is not found");
		
		Message message = messages.get(messageId);
		if(message == null) {
			Response res = Response.status(Status.NOT_FOUND).entity(er1).build();
			throw new WebApplicationException(res);
		}
		
		Map<Long, Comment> comments = message.getComments();
		Comment comment = comments.get(commentId);
		
		if(comment == null) {
			Response res1 = Response.status(Status.NOT_FOUND).entity(er2).build();
			throw new WebApplicationException(res1);
		}
		
		return comment;
	}
	
	public Comment addComment(Long messageId, Comment comment) {
		
		ErrorMessage er1 = new ErrorMessage(404, "The message with id: "+ messageId +" is not found");
		Message message = messages.get(messageId);
		if(message == null) {
			Response response = Response.status(Status.NOT_FOUND).entity(er1).build();
			throw new WebApplicationException(response);
		}
		
		comment.setId((long) (message.getComments().size()+1));
		comment.setCreated(new Date());
		comment.setMessage(message);
		return message.addComment(comment);
	}
	
	public Comment updateComment(Long messageId, Comment comment) {
		ErrorMessage er1 = new ErrorMessage(404, "The message with id: "+ messageId +" is not found");
		ErrorMessage er2 = new ErrorMessage(404, "The comment with id: "+ comment.getId() +" is not found");
		
		Message message = messages.get(messageId);
		if(message == null) {
			Response response = Response.status(Status.NOT_FOUND).entity(er1).build();
			throw new WebApplicationException(response);
		}
		
		Map<Long, Comment> comments = message.getComments();
		Comment old = comments.get(comment.getId());
		if(old == null) {
			Response response = Response.status(Status.NOT_FOUND).entity(er2).build();
			throw new WebApplicationException(response);
		}
		comment.setCreated(old.getCreated());
		comments.replace(comment.getId(), comment);
		return comment;
	}
	
	public Response removeComment(Long messageId, Long commentId) {
		ErrorMessage er1 = new ErrorMessage(404, "The message with id: "+ messageId +" is not found");
		
		Message message = messages.get(messageId);
		if(message == null) {
			Response res = Response.status(Status.NOT_FOUND).entity(er1).build();
			throw new WebApplicationException(res);
		}
		
		Map<Long, Comment> comments = message.getComments();
		comments.remove(commentId);
		return Response.status(Status.NO_CONTENT).build();
	}
}
