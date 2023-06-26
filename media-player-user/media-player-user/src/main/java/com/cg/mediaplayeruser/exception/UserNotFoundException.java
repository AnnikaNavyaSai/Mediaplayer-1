package com.cg.mediaplayeruser.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException{
		public UserNotFoundException() {
		}
		
		public UserNotFoundException(String msg) {
			super(msg);
		}

}
