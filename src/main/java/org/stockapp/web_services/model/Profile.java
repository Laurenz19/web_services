package org.stockapp.web_services.model;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *Class Profile created on 21/01/21 
 **/
@XmlRootElement
public class Profile {
	
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private Date created;
	
	/**
	 *no-argument constructor 
	 **/
	public Profile() {
		
	}
	
	public Profile(Long id, String username, String firstName, String lastName) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
