package com.mediaplayer.exceptions;

import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class InvalidCommentException extends RuntimeException {
	private final int status;
    private final String message;
    private final LocalDateTime timestamp;

    public InvalidCommentException(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	
    

}
