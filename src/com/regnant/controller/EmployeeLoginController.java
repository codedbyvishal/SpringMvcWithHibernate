package com.regnant.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.regnant.dto.Employee;

@Controller
public class EmployeeLoginController {

	@Autowired
	EmployeeService service;

	@RequestMapping("/login")
	public String login() throws Exception {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("command") Employee employee, BindingResult result, HttpSession session) {
		String loginName = employee.getLoginName();
		String entPwd = employee.getPassword();
		Employee validUser = service.getEmpByLoginName(loginName);
		
		int status = validUser.getStatus();
		int attempts = validUser.getAttempts();
		if (attempts < 5 && status != 0) {
			String pwd = validUser.getPassword();
			if (entPwd.equals(pwd)) {
				int count = 0;
				service.changeAttempts(loginName, count);
				session.setAttribute("myId", validUser.getId());
				session.setAttribute("loginName", validUser.getLoginName());
				session.setAttribute("password", validUser.getPassword());
				session.setAttribute("usertype", validUser.getUserType());
				session.setAttribute("name", validUser.getName() + "," + validUser.getlName());
				session.setAttribute("status", validUser.getStatus());
				session.setAttribute("attempt", validUser.getAttempts());
				if (validUser.getUserType().equalsIgnoreCase("user")) {
					ModelAndView modelAndView = new ModelAndView("showforUser", "emp", validUser);
					return modelAndView;
				} else {
					ModelAndView modelAndView = new ModelAndView("profile", "emp", validUser);
					return modelAndView;
				}
			} else if (!entPwd.equals(pwd)) {
				int count = attempts + 1;
				service.changeAttempts(loginName, count);
				return new ModelAndView("login", "msg", "invalid Login");
			}
			
			
		}
		return new ModelAndView("login", "msg", "Your account is locked!!! contact admin");

	}

}
