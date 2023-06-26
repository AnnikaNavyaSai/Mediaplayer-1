package com.cg.mediaplayeruser.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistException extends RuntimeException{
	public UserAlreadyExistException() {
	}
	
	public UserAlreadyExistException(String msg) {
		super(msg);
	}

}
