package com.walab.hgu.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walab.hgu.service.UserService;
import com.walab.hgu.DTO.UserDTO;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	UserService userService;


	@RequestMapping(value = "", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/registerSave", method = RequestMethod.POST)
	@ResponseBody
	public void registerSave(HttpServletRequest httpServletRequest) {

		String name = httpServletRequest.getParameter("name");
		String email = httpServletRequest.getParameter("email");
		String phoneNumber = httpServletRequest.getParameter("phone");
		int admin = 2;

		UserDTO u = new UserDTO();
		u.setName(name);
		u.setEmail(email);
		u.setPhone(phoneNumber);
		u.setAdmin(admin);
		System.out.println("registerSave Controller: " + u);
		int result = userService.createUserInfo(u);
		System.out.println(result);
		u.setId(userService.readUserIDByEmail(email));
		httpServletRequest.getSession().setAttribute("user", u);

	}

}
