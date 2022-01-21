package org.stockapp.web_services.model;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;



/**
 * Class Message created on 21/01/2021
 **/
@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date created;
	private String author;
	
	
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
	
}
