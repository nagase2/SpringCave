package com.web.controllers;


import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.dao.User;
import com.web.service.UsersService;

@Controller
public class LoginController {
	
	static Logger logger = Logger.getRootLogger();
	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService){
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/logout")
	public String showLogout(){
		return "logout";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model){
		
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	@RequestMapping(value="/createaccount",method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result){
		logger.info("createaccount");
		
		if(result.hasErrors()){
			logger.warn("error has been happened");
			return "newaccount";
		}
		user.setAuthority("user");
		user.setEnabled(true);
		
		//ユーザ重複チェック
		if(usersService.exists(user.getUsername())){
			logger.info("Account has been duplicated After check.");
			result.rejectValue("username", "DupliateKey.user.username");
			return "newaccount";
		}
		
		try{
		usersService.create(user);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		
		return "accountcreated";
	}
	
}
