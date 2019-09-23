package com.company.border.main;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company.border.dto.BorderDTO;
import com.company.border.service.BorderService;
import com.company.user.dto.UserDTO;

@Controller
public class BorderController {
	private static final Logger logger = LoggerFactory.getLogger(BorderController.class);
	
	@Inject
	private BorderService borderService;
	
	@RequestMapping(value="border")
	public String border(Model model) throws Exception {
		logger.info("border Called");
		model.addAttribute("borderList",borderService.borderList());
		
		return "otherPage/border";
	}
	
	@RequestMapping(value="borderWrite")
	public String borderWrite(@ModelAttribute("borderDTO")BorderDTO borderDTO) throws Exception {
		logger.info("borderWrite Called");
		return "otherPage/borderWrite";
	}
	@RequestMapping(value="borderWriteAction")
	public String borderWriteAction(BorderDTO borderDTO, HttpSession httpSession) throws Exception {
		logger.info("borderWrite Action");
		UserDTO userDTO = (UserDTO)httpSession.getAttribute("login");
		String userId = userDTO.getUserId();
		borderDTO.setUserId(userId);
		
		borderService.borderWrite(borderDTO);
		
		return "redirect:border";
	}
	@RequestMapping(value="borderView", method=RequestMethod.GET)
	public String borderView(@ModelAttribute("borderId") int borderId,BorderDTO borderDTO,Model model) throws Exception {
		logger.info("borderView"+borderId);
		borderDTO = borderService.borderView(borderId);
		model.addAttribute(borderDTO);
		return "otherPage/borderView";
	}
	@RequestMapping(value="borderUpdate")
	public String borderUpdate(@ModelAttribute("borderId")int borderId, Model model, HttpSession httpSession) throws Exception {
		logger.info("borderUpdate Called");
		BorderDTO borderDTO = borderService.borderView(borderId);
		model.addAttribute(borderDTO);
		httpSession.setAttribute("borderDTO", borderDTO);
		return "otherPage/borderUpdate";
	}

	@RequestMapping(value="borderUpdateAction")
	public String borderUpdateAction(@ModelAttribute("borderDTO") BorderDTO borderDTO, HttpSession httpSession) throws Exception {
		logger.info("borderUpdate Action");
		BorderDTO bo = (BorderDTO)httpSession.getAttribute("borderDTO");
		int borderId = bo.getBorderId();
		borderDTO.setBorderId(borderId);
		borderService.borderUpdate(borderDTO);
		return "redirect:border";
	}
	
	@RequestMapping(value="borderDelete")
	public String borderDelete(@ModelAttribute("borderId")int borderId) throws Exception {
		logger.info(borderId + "borderDelete");
		borderService.borderDelete(borderId);
		return "redirect:border";
	}
}
