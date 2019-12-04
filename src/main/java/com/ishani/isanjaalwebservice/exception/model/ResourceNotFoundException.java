package com.ishani.isanjaalwebservice.exception.model;

import org.springframework.http.HttpStatus;
public class ResourceNotFoundException extends RuntimeException {

	/**
	 *Generic Exception class to throw when requested resource is not found.
	 *@author Yoomes 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private static final HttpStatus status = HttpStatus.NOT_FOUND;
	public String getMessage() {
		return message;
	}
	/**
	 * 
	 * @param message represents reasons for exception.
	 */
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 
	 * @return HttpStatus represents HttpStatus that this exception should map to.
	 */
	public static HttpStatus getStatus() {
		return status;
	}
	
	public ResourceNotFoundException(String message) {
		this.message = message;
	}
}
