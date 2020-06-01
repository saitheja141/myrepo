package com.example.employeemangement;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
/**
 * Customized Response class used mainly for custom exception 
 * @author saitheja macharla
 *
 */
public class GlobalExceptionResponse {

	public String message;
	public HttpStatus httpStatus;
	public LocalDateTime localDateTime;
	public boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public GlobalExceptionResponse(String message, HttpStatus httpStatus, LocalDateTime localDateTime) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.localDateTime = localDateTime;
	}

	public GlobalExceptionResponse() {
		super();
	}

	
}
