package com.company.menu.main;

import java.io.File;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.company.border.dto.BorderDTO;
import com.company.border.dto.Pagination;
import com.company.border.main.Criteria;
import com.company.menu.dto.MenuDTO;
import com.company.menu.service.MenuService;
import com.company.reply.dto.ReplyDTO;
import com.company.user.dto.UserDTO;
import com.company.utils.UploadFileUtils;

@Controller
public class MenuController {
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Inject
	private MenuService menuService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping("fWrtie")
	public String fWrite() {
		logger.info("fWrite Call");
		
		return "menu/fWrite";
	}
	
	@RequestMapping(value="menuF")
	public String menuF(Model model, Criteria criteria) throws Exception {
		logger.info("menuF Call");
		Pagination pagination = new Pagination();
		pagination.setCriteria(criteria);
		pagination.setTotalCnt(menuService.menuCnt(criteria));
		model.addAttribute("menuList",menuService.menuList(criteria));
		model.addAttribute("pagination", pagination);
		
		return "menu/menuF";
	}
	
	@RequestMapping(value="menuWriteAction", method=RequestMethod.POST)
	public String menuWriteAction(MenuDTO menuDTO, HttpSession httpSession, MultipartFile file) throws Exception {
		logger.info("MenuWriteAction");
		System.out.println(file);
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file != null) {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		menuDTO.setGbsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		menuDTO.setGbsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);

		UserDTO userDTO = (UserDTO)httpSession.getAttribute("login");
		String userId = userDTO.getUserId();
		menuDTO.setUserId(userId);
		System.out.println(userId);
		menuService.menuWrite(menuDTO);
		return "redirect:menuF";
	}
	@RequestMapping(value="fMenuView", method=RequestMethod.GET)
	public String menuView(@ModelAttribute("menuId")int menuId,@ModelAttribute("criteria")Criteria criteria, MenuDTO menuDTO, Model model) throws Exception {
		logger.info("menuView : " + menuId);
		menuDTO = menuService.menuView(menuId);
		model.addAttribute(menuDTO);
		model.addAttribute(criteria);
		return "menu/fMenuView";
	}
}
