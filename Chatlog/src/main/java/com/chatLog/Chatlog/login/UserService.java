package com.chatLog.Chatlog.login;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private static List<User> userList = new ArrayList<>();;

	static {
		
		User amit = new User("Amit");
		amit.addNewMessage("Hey");
		amit.addNewMessage("Whatsup");
		amit.addNewMessage("I Love you");
		amit.addNewMessage("I hate you");
		amit.addNewMessage("I will break your bone");
		amit.addNewMessage("I can sing");
		userList.add(amit);
		userList.add(new User("Naveen"));
	}

	public User getUserByName(String name) {
		User currentUser = userList.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);

		if (currentUser == null) {
			addNewUser(name, currentUser);
		}

		return currentUser;

	}


	public void addNewUser(String name, User user) {
		user = new User(name);
	}

	public void deleteCurrentUserLogs(String userName) {

		Predicate<? super User> predicate = user -> user.getName().equals(userName);

		User user = userList.stream().filter(predicate).findFirst().get();

		user.clearAllMessages();

	}

	public void deleteCurrentUserLogsByMsgId(String userName, int messageId) {

		Predicate<? super User> predicate = user -> user.getName().equals(userName);

		User user = userList.stream().filter(predicate).findFirst().get();

		user.clearMessageById(messageId);

	}

}
