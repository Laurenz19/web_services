package org.stockapp.web_services.resources;

import java.util.List;

import org.stockapp.web_services.model.Message;
import org.stockapp.web_services.services.MessageService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("messages")
public class messageResource {
 
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return this.messageService.getAllMessages();
	}
}
