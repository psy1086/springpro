package com.company.border.main;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.border.dto.BorderDTO;
import com.company.border.service.BorderService;

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
	public String borderWriteAction(BorderDTO borderDTO) throws Exception {
		logger.info("borderWrite Action");
		borderService.borderWrite(borderDTO);
		return "redirect:border";
	}
	
}
