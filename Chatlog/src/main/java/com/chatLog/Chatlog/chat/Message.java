package com.chatLog.Chatlog.chat;

import java.time.LocalDate;

public class Message {
	
	private int messageid;
	private String message;
	private LocalDate timestamp;
	// isSent -> true - sent by user
	// isSent-> false- received by user
	private boolean isSent;

	public Message(String message) {
		super();
		this.message = message;
		this.timestamp = LocalDate.now();
		this.isSent = true;
	}
	
	public String getMessage() {
		return message;
	}
	
}
