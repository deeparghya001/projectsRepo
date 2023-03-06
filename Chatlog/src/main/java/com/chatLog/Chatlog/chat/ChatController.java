package com.chatLog.Chatlog.chat;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chatLog.Chatlog.login.User;
import com.chatLog.Chatlog.login.UserService;

@SessionAttributes("currentUserName")
@Controller
public class ChatController {
	
	private UserService userService;
	
	public ChatController(UserService userService) {
		super();
		this.userService = userService;
	}


//
	@RequestMapping(value = "Chat-Logs-Default", method = RequestMethod.GET)
	public String showAllChatLogs(@RequestParam String userName, ModelMap model) {
		User user = userService.getUserByName(userName);

		List<String> msgList = user.getRequiredMessage(-1, 10);
		model.addAttribute("msgList", msgList);
		
		return "chatLogs";
	}
	
	
	@RequestMapping(value = "Chat-Logs-Limited", method = RequestMethod.GET)
	public String inputForLimitedLogs() {
		return "limitedLogForm";
	}
	
	@RequestMapping(value = "Chat-Logs-Limited", method = RequestMethod.POST)
	public String showLimitedChatLogs( 	@RequestParam int start,
									@RequestParam int limit,
									ModelMap model) {
		
		String currentUser = (String) model.get("currentUserName");
		User user = userService.getUserByName(currentUser);

		List<String> msgList = user.getRequiredMessage(start, limit);
		model.addAttribute("msgList", msgList);
		
		return "chatLogs";
	}
	
	@RequestMapping(value = "Chat-Logs-Delete", method = RequestMethod.GET)
	public String deleteAllChatLogs(ModelMap model) {
		
		String currentUser = (String) model.get("currentUserName");
		User user = userService.getUserByName(currentUser);

		user.clearAllMessages();
		
		List<String> msgList = user.getRequiredMessage(-1, 10);
		model.addAttribute("msgList", msgList);
		
		return "chatLogs";
	}
	
	@RequestMapping(value = "Chat-Logs-Delete-Single-Log", method = RequestMethod.GET)
	public String viewDeleteChatLogsById() {
		
		return "deleteLogForm";
	}
	
	@RequestMapping(value = "Chat-Logs-Delete-Single-Log", method = RequestMethod.POST)
	public String deleteChatLogsById(@RequestParam int id, ModelMap model) {
		
		String currentUser = (String) model.get("currentUserName");
		User user = userService.getUserByName(currentUser);

		user.clearMessageById(id);
		
		List<String> msgList = user.getRequiredMessage(-1, 10);
		model.addAttribute("msgList", msgList);
		
		return "chatLogs";
	}
	
	@RequestMapping(value = "Add-New-Log", method = RequestMethod.GET)
	public String viewAddNewLog() {
		return "addNewLog";
	}
	
	@RequestMapping(value = "Add-New-Log", method = RequestMethod.POST)
	public String addNewLog(@RequestParam String log, ModelMap model) {
		
		String currentUser = (String) model.get("currentUserName");
		User user = userService.getUserByName(currentUser);
		
		user.addNewMessage(log);
		
		List<String> msgList = user.getRequiredMessage(-1, 10);
		model.addAttribute("msgList", msgList);
		
		return "chatLogs";
	}
	

}
