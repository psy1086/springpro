package com.company.user.main;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.user.dto.UserDTO;
import com.company.user.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value="userRegister", method=RequestMethod.POST)
	public String userRegister(@ModelAttribute("userDTO")UserDTO userDTO) throws Exception{
		logger.info("userRegister Action");
		userService.userRegister(userDTO);
		return "otherPage/userLogin";
		
	}
//	@RequestMapping(value="userLogin", method=RequestMethod.POST)
//	public String userLogin(@ModelAttribute("userId")String userId) throws Exception {
//		logger.info("UserLogin Action");
//		userService.userLogin(userId);
//		return "home";
//	}
	@RequestMapping(value="userLogin", method=RequestMethod.POST) 
	public String userLogin(UserDTO userDTO, HttpServletRequest req) throws Exception {
		logger.info("userLogin Action");
		HttpSession httpSession = req.getSession();
		UserDTO login = userService.userLogin(userDTO);
		if(login == null) {
			httpSession.setAttribute("user", null);
			return "otherPage/userLogin";
		}
		else {
			httpSession.setAttribute("user", login);
			return "home";
		}
	}
	@RequestMapping(value="logout")
	public String logout(HttpSession httpSession) throws Exception {
		logger.info("Logout Action");
		httpSession.invalidate();
		return "home";
	}
}

