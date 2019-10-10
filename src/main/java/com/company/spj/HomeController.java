package com.company.spj;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.user.dto.LoginDTO;
import com.company.user.dto.UserDTO;
import com.company.user.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private UserService userService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home() {
		logger.info("Home Called..");
		return "index";
	}
	@RequestMapping(value="about")
	public String about() {
		logger.info("About Called..");
		return "about";
	}
	@RequestMapping(value="service")
	public String service() {
		logger.info("Service Called..");
		return "service";
	}
	@RequestMapping(value="contact")
	public String contact() {
		logger.info("Contact Called..");
		return "contact";
	}
	
	@RequestMapping(value="menuS") 
	public String menuS() {
		logger.info("MenuS Called");
		return "menu/menuS";
	}
	@RequestMapping(value="menuT") 
	public String menuT() {
		logger.info("MenuT Called");
		return "menu/menuT";
	}
	@RequestMapping(value="register")
	public String register(@ModelAttribute("userDTO")UserDTO userDTO) {
		logger.info("Register Called");
		return "otherPage/userRegister";
	}
	@RequestMapping(value="login")
	public String login(@ModelAttribute("userDTO")UserDTO userDTO) {
		logger.info("Login Called");
		return "otherPage/userLogin";
	}

	
}
