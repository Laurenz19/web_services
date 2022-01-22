package org.stockapp.web_services.resources;

import java.util.List;

import org.stockapp.web_services.model.Message;
import org.stockapp.web_services.services.MessageService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class messageResource {
 
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages() {
		return this.messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessagebyId(@PathParam("messageId") Long id) {
		return this.messageService.getMessage(id);
	}
	
	@POST
	public Message addMessage(Message message) {
		return this.messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(Message message, @PathParam("messageId") Long id) {
		message.setId(id);
		return this.messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public List<Message> messageMessage(@PathParam("messageId") Long id) {
		return this.messageService.removeMessage(this.messageService.getMessage(id));
	}
	
	
	/**
	 *This is a test to get the params passed by the uri 
	 *an
	 **/
	@GET
	@Path("generate/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParams(@PathParam("param") String param) {
		this.messageService.generateMessage();
		return "this request generate messages and get the param: \""+ param + "\"";
	}
}
