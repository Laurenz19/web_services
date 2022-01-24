package org.stockapp.web_services.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;



/**
 * Class Message created on 21/01/2022
 **/
@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long, Comment> comments = new HashMap<>();
	

	//no argument constructor
	public Message() {
		
	}
	
	/**
	 * constructor
	 **/
	public Message(long id, String message, String author) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	/**
	 * Getters & Setters
	 **/
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
