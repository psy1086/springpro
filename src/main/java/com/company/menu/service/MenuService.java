package com.company.menu.service;

import java.util.List;

import com.company.border.main.Criteria;
import com.company.menu.dto.MenuDTO;

public interface MenuService {
	public List<MenuDTO> menuList(Criteria criteria) throws Exception;
	public int menuWrite(MenuDTO menuDTO) throws Exception;
	public int menuUpdate(MenuDTO menuDTO) throws Exception;
	public int menuDelete(int menuId) throws Exception;
	public MenuDTO menuView(int menuId) throws Exception;
	public int menuCnt(Criteria criteria) throws Exception;
	public void menuViewCnt(int menuId) throws Exception;
	public void replyCnt(int menuId) throws Exception;
	public void replyDeleteCnt(int menuId) throws Exception;
}
