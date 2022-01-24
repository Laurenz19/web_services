package org.stockapp.web_services.database;

import java.util.HashMap;
import java.util.Map;

import org.stockapp.web_services.model.Comment;
import org.stockapp.web_services.model.Message;
import org.stockapp.web_services.model.Profile;

public class Database {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}

}
