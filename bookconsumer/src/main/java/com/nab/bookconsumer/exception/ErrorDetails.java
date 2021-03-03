package com.nab.bookconsumer.exception;

import java.util.Date;

/*
 * Formatter Error Message class
 */
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;
	private String status;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
