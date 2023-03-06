package com.chatLog.Chatlog.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("currentUserName")
public class LoginController {
	
	private UserService userService;
	
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPageWithUser(@RequestParam String name, ModelMap model) {
		
		User user = userService.getUserByName(name);
		
		model.addAttribute("currentUserName", name);

		return "welcome";
	}
}
