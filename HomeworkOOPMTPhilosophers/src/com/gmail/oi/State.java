package com.gmail.oi;

public enum State {
	THINKING("thinking..."), EATING("eating...");
	
	String message;
	
	State(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
