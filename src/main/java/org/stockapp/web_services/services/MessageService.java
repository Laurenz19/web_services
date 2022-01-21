package org.stockapp.web_services.services;

import java.util.ArrayList;
import java.util.List;

import org.stockapp.web_services.model.Message;

public class MessageService {
	
	public List<Message> getAllMessages(){
		int n = 10;
		List<Message> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			Message message = new Message(i, "Hello World - " + i, "Laurenzio Sambany");
			list.add(message);
		}
		
		return list;
	}
}
