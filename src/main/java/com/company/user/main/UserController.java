package com.company.user.main;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
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
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="userRegister", method=RequestMethod.POST)
	public String userRegister(@ModelAttribute("userDTO")UserDTO userDTO) throws Exception{
		logger.info("userRegister Action");
		String hashedPw = BCrypt.hashpw(userDTO.getUserPassword(), BCrypt.gensalt());
		userService.userRegister(userDTO);
		userDTO.setUserPassword(hashedPw);

		return "otherPage/userLogin";
	}
	

	@RequestMapping(value="otherPage/userLoginPost", method=RequestMethod.POST)
	public void userLogin(LoginDTO loginDTO, HttpSession httpSession, Model model, HttpServletRequest request) throws Exception {
		logger.info("userController userLogin");
		UserDTO userDTO = userService.userLogin(loginDTO);
		
		if(userDTO == null || !BCrypt.checkpw(loginDTO.getUserPassword(), userDTO.getUserPassword())) {
			return;
		}
		model.addAttribute("user", userDTO);
	}

	@RequestMapping(value="logout")
	public String logout(HttpSession httpSession) throws Exception {
		logger.info("Logout Action");
		httpSession.invalidate();
		return "home";
	}
	
	@RequestMapping(value="pwFindAction")
	public String pwFindAction(@ModelAttribute("userDTO")UserDTO userDTO, String userId, String userEmail) throws Exception {
		logger.info("pwFindAction");
		Map<String, Object> map = new HashMap<String, Object>();
		String userEmailHash = new TemKey().getKey(50, false);
		MailUtils sendMail = new MailUtils(mailSender);
		map.put("userId", userId);
		map.put("userEmail", userEmail);
		int result = userService.pwFind(map);
		if(result>0) {
			sendMail.setSubject("회원가입 이메일 인증");
			sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
					.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
					.append("<a href='http://localhost:8089/spj/emailConfirm?userId=")
					.append(userDTO.getUserId())
					.append("&email=")
					.append(userDTO.getUserEmail())
					.append("&userEmailHash=")
					.append(userEmailHash)
					.append("' target='_blenk'>이메일 인증 확인</a>")
					.toString());
			sendMail.setFrom("andrea122245@gmail.com ", "admin");
			sendMail.setTo(userDTO.getUserEmail());
			sendMail.send();
			return "otherPage/emailChecked";
		}
		else {
			return "passwordFind";
		}
	}
	
	@RequestMapping(value="emailConfirm")
	public String rePassword(@ModelAttribute("userDTO")UserDTO userDTO) throws Exception {
		logger.info("rePassword Call");
		
		System.out.println(userDTO.getUserId());
		return "otherPage/rePassword";
	}
	@RequestMapping(value="rePasswordAction")
	public String rePasswordAction(@ModelAttribute("userDTO")UserDTO userDTO, String userId,String userPassword) throws Exception {
		logger.info("rePassword Action");
		Map<String, Object> map = new HashMap<String, Object>();
		String hashedPw = BCrypt.hashpw(userPassword, BCrypt.gensalt());
		map.put("userId", userId);
		map.put("userPassword", hashedPw);
		userService.rePasswordAction(map);

		return "otherPage/userLogin";
	}

}

