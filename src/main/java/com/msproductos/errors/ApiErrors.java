package com.msproductos.errors;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class ApiErrors {
	
	
	String message;
	List<String> details;
	HttpStatus status;
	LocalDateTime timestamp;
	
	
	public ApiErrors() {
		
	}
	
	public ApiErrors(String message, List<String> details, HttpStatus status, LocalDateTime timestamp) {
		//super();
		this.message = message;
		this.details = details;
		this.status = status;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	

}





