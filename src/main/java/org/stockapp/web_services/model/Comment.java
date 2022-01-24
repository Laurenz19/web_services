package org.stockapp.web_services.model;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	
	private Long id;
	private String message;
	private Date created;
	private String author;
	
	/**
	 * non argument constructor
	 **/
	public Comment() {
			
	}
	
	/**
	 * constructor 
	 **/
	public Comment(String message, String author) {
		this.message = message;
		this.author = author;
		this.created = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
