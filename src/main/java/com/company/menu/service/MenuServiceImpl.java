package com.company.menu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.menu.main.MenuCriteria;
import com.company.menu.dao.MenuDAO;
import com.company.menu.dto.MenuDTO;

@Service
public class MenuServiceImpl implements MenuService {

	@Inject
	private MenuDAO menuDAO;
	
	@Override
	public List<MenuDTO> menuList(MenuCriteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.menuList(criteria);
	}

	@Override
	public int menuWrite(MenuDTO menuDTO) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.menuWrite(menuDTO);
	}

	@Override
	public int menuUpdate(MenuDTO menuDTO) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.menuUpdate(menuDTO);
	}

	@Override
	public int menuDelete(int menuId) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.menuDelete(menuId);
	}

	@Override
	public MenuDTO menuView(int menuId) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.menuView(menuId);
	}

	@Override
	public int menuCnt(MenuCriteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.menuCnt(criteria);
	}

	@Override
	public void menuViewCnt(int menuId) throws Exception {
		// TODO Auto-generated method stub
		menuDAO.menuViewCnt(menuId);
	}

	@Override
	public void replyCnt(int menuId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void replyDeleteCnt(int menuId) throws Exception {
		// TODO Auto-generated method stub

	}

}
