package org.stockapp.web_services.exception;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1074546152047367072L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
