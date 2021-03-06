package com.company.menu.main;

import java.io.File;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.company.menu.dto.MenuPagination;
import com.company.menu.main.MenuCriteria;
//import com.company.border.dto.Pagination;
//import com.company.border.main.Criteria;
import com.company.menu.dto.MenuDTO;
import com.company.menu.service.MenuService;
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
	public String menuF(Model model, MenuCriteria criteria,MenuDTO menuDTO) throws Exception {
		logger.info("menuF Call");
		MenuPagination pagination = new MenuPagination();
		pagination.setCriteria(criteria);
		pagination.setTotalCnt(menuService.menuCnt(criteria));
		model.addAttribute("menuList",menuService.menuList(criteria));
		model.addAttribute("pagination", pagination);
		model.addAttribute(menuDTO);
		
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
		 logger.info("FileUpload");
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
	public String menuView(@ModelAttribute("menuId")int menuId,@ModelAttribute("criteria")MenuCriteria criteria, MenuDTO menuDTO, Model model) throws Exception {
		logger.info("menuView : " + menuId);
		menuDTO = menuService.menuView(menuId);
		menuService.menuViewCnt(menuId);
		model.addAttribute(menuDTO);
		model.addAttribute(criteria);
		return "menu/fMenuView";
	}
	
	@RequestMapping(value="fMenuUpdate")
	public String menuUpdate(@ModelAttribute("menuId")int menuId, Model model, HttpSession httpSession) throws Exception {
		logger.info("menuUpdate Call");
		MenuDTO menuDTO = menuService.menuView(menuId);
		model.addAttribute(menuDTO);
		httpSession.setAttribute("menuDTO", menuDTO);
		return "menu/fMenuUpdate";
	}
	
	@RequestMapping(value="menuUpdateAction")
	public String menuUpdateAction(@ModelAttribute("menuDTO") MenuDTO menuDTO, HttpSession httpSession, MultipartFile file, HttpServletRequest req) throws Exception {
		logger.info("menuUpdate Action");
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			new File(uploadPath + req.getParameter("gdsImg")).delete();
			new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
			
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = null;
			
			menuDTO.setGbsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			menuDTO.setGbsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		}
		else {
			menuDTO.setGbsImg(req.getParameter("gbsImg"));
			menuDTO.setGbsThumbImg(req.getParameter("gbsThumbImg"));
		}
		MenuDTO mo = (MenuDTO)httpSession.getAttribute("menuDTO");
		int menuId = mo.getMenuId();
		menuDTO.setMenuId(menuId);
		menuService.menuUpdate(menuDTO);
		return "redirect:menuF";
	}
	
	@RequestMapping(value="fMenuDelete")
	public String menuDelete(@ModelAttribute("menuId")int menuId, HttpServletRequest req) throws Exception {
		logger.info(menuId+"DeleteAction");
		new File(uploadPath + req.getParameter("gdsImg")).delete();
		new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
		
		menuService.menuDelete(menuId);
		return "redirect:menuF";
	}
}
