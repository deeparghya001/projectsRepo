package com.chatLog.Chatlog.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.chatLog.Chatlog.chat.Message;

import jakarta.validation.constraints.Size;

public class User {
	
	@Size(max = 16 , message = "The Length of name cannot exceed 16 characters!")
	private String name;
	
//	private List<Message> msgList;
	private HashMap<Integer, Message> msgList;
	private int idCounter;

	public User(String name) {
		super();
		this.name = name;
		this.idCounter = 0;
		this.msgList = new HashMap<>();
	}
	
	public void clearAllMessages() {
		this.idCounter =  0;
		msgList.clear();
	}
	
	public void clearMessageById(int id) {
		msgList.remove(id);
	}
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addNewMessage(String message) {
//		msgList.add(new Message(message));
		
		msgList.put(++idCounter, new Message(message));
	}
	
	public List<String> getRequiredMessage(int start, int limit) {
		if(start == -1)
			start = idCounter;
		List<String> list = new ArrayList<>();
		for(int i = start; i > 0 && i > start-limit ; i--) {
			
			Message msg = msgList.get(i);
			if(msg != null)
				list.add(msg.getMessage());
		}
		
		return list;
	}

}
