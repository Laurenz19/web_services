package org.stockapp.web_services.model;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	
	private Long id;
	private String content;
	private Date created;
	private String author;
	private Message message;
	
	
	/**
	 * non argument constructor
	 **/
	public Comment() {
			
	}
	
	/**
	 * constructor 
	 **/
	public Comment(String content, String author) {
		this.content = content;
		this.author = author;
		this.created = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
