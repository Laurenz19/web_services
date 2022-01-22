package org.stockapp.web_services.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.stockapp.web_services.database.Database;
import org.stockapp.web_services.model.Message;

/**
 *Useful services for the Class Message
 *created on 22/01/2022 
 **/
public class MessageService {
	
	private Map<Long, Message> messages = Database.getMessages();
	
	/**
	 *Constructor 
	 **/
	
	/*public MessageService() {
		for(int i=1; i<=2; i++) {
			Message message = new Message(i, "Hello Guys! this is the message n°: " +i, "Laurenzio Sambany");
			messages.put(message.getId(), message);
		}
	}*/
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.replace(message.getId(), message);
		
		return messages.get(message.getId());
	}
	
	public List<Message> removeMessage(Message message){
		if(message.getId() <= 0) {
			return null;
		}
		messages.remove(message.getId());
		return new ArrayList<Message>(messages.values());
	}
	
	public void generateMessage(){
		for(int i=1; i<=10; i++) {
			Message message = new Message(i, "Hello Guys! this is the message n°: " +i, "Laurenzio Sambany");
			messages.put(message.getId(), message);
		}
	}
	
	/**
	 *Pagination & Filter 
	 **/
	
	public List<Message> getMessagesbyYear(int year){
		List<Message> messagesbyYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		
		for(Message message: messages.values()) {
			//get the message's created property & parse it
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messagesbyYear.add(message);
			}
		}
		
		return messagesbyYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		List<Message> all_messages = new ArrayList<Message>(messages.values());
		
		if(start + size > all_messages.size()) {
			return all_messages;
		}
		return all_messages.subList(start, start + size);
	}
	
}
