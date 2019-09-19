package com.company.user.main;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.user.dto.LoginDTO;
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
		String hashedPw = BCrypt.hashpw(userDTO.getUserPassword(), BCrypt.gensalt());
		userDTO.setUserPassword(hashedPw);
		userService.userRegister(userDTO);
		return "otherPage/userLogin";
		
	}

	@RequestMapping(value="userLoginPost", method=RequestMethod.POST)
	public void userLogin(LoginDTO loginDTO, HttpSession httpSession, Model model) throws Exception {
		logger.info("userController userLogin");
		UserDTO userDTO = userService.userLogin(loginDTO);
		
		if(userDTO == null || !BCrypt.checkpw(loginDTO.getUserPassword(), userDTO.getUserPassword())) {
			return;
		}
		model.addAttribute("user", userDTO);
	}
	
	
//	@RequestMapping(value="userLogin", method=RequestMethod.POST) 
//	public ModelAndView userLogin(UserDTO userDTO, HttpServletRequest req) throws Exception {
//		logger.info("userLogin Action");
//		ModelAndView mv = new ModelAndView();
//		HttpSession httpSession = req.getSession();
//		UserDTO login = userService.userLogin(userDTO);
//		if(login == null) {
//			mv.setViewName("otherPage/userLogin");
//			httpSession.setAttribute("userId", null);
//			return mv;
//		}
//		else {
//			//mv.addObject("user",userDTO.getUserId());
//			httpSession.setAttribute("userId", userDTO.getUserId());
//			mv.setViewName("home");
//			return mv;
//		}
//	}

	
	@RequestMapping(value="logout")
	public String logout(HttpSession httpSession) throws Exception {
		logger.info("Logout Action");
		httpSession.invalidate();
		return "home";
	}
}

