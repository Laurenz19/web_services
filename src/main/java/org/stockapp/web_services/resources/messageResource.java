package org.stockapp.web_services.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.stockapp.web_services.model.Message;
import org.stockapp.web_services.resources.beans.MessageFilterBean;
import org.stockapp.web_services.services.MessageService;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;


@Path("messages")
@Produces( value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class messageResource {
 
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		List<Message> messages = new ArrayList<>();
		
		if(filterBean.getYear() == 0 && filterBean.getStart() == 0 && filterBean.getSize() ==0) {
			messages = this.messageService.getAllMessages();
		}else if(filterBean.getYear() > 0 && filterBean.getStart() == 0 && filterBean.getSize() ==0) {
			messages = this.messageService.getMessagesbyYear(filterBean.getYear());
		}else if(filterBean.getYear() == 0 && filterBean.getStart() >= 0 || filterBean.getSize() >=0){
			messages = this.messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messages;
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessagebyId(@PathParam("messageId") Long id) {
		return this.messageService.getMessage(id);
	}
	
	/*
	Method 1:
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message) throws URISyntaxException {
		message =this.messageService.addMessage(message);
		return Response.created( new URI("/web_services/webapi/messages/" + message.getId()))
				       .entity(message)
				       .build();
	}
	
	Method 2:
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException {
		message =this.messageService.addMessage(message);
		String uri = uriInfo.getAbsolutePath().toString();
		return Response.created( new URI(uri + message.getId()))
				       .entity(message)
				       .build();
	}
	*/
	
	/**
	 * Here is another way add location
	 * The methods above are not really practical   
	 * (Recommended)
	 **/
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo){
		message =this.messageService.addMessage(message);
		String new_id = String.valueOf(message.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(new_id).build();
		return Response.created(uri)
				       .entity(message)
				       .build();
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMessage(Message message, @PathParam("messageId") Long id) {
		message.setId(id);
		message = this.messageService.updateMessage(message);
		return Response.ok()
				       .entity(message)
				       .build();
	}
	
	@DELETE
	@Path("/{messageId}")
	public Response messageMessage(@PathParam("messageId") Long id) {
		//this.messageService.removeMessage(this.messageService.getMessage(id));
		return Response.noContent()
				       .entity(this.messageService.removeMessage(this.messageService.getMessage(id)))
				       .build();
	}
	
	
	/**
	 * This is a test to get the params passed by the uri 
	 **/
	@GET
	@Path("generate/{param}")
	public List<Message> getParams(@PathParam("param") String param) {
		//"this request generate messages and get the param: \""+ param + "\"";
		return this.messageService.generateMessage();
	}
	
	
	/**
	 * Here we implement the sub-resource
	 * it is annotated with Path annotation but no with HTTP method 
	 **/
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
