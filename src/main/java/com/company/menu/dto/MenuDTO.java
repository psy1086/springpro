package com.company.menu.dto;

public class MenuDTO {
	int menuId;
	String userId;
	String menuTitle;
	String menuContent;
	String menuSubFTitle;
	String menuSubFContent;
	String menuSubSTitle;
	String menuSContent;
	String menuTTitle;
	String menuTContent;
	String menuFootContent;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMenuTitle() {
		return menuTitle;
	}
	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	public String getMenuContent() {
		return menuContent;
	}
	public void setMenuContent(String menuContent) {
		this.menuContent = menuContent;
	}
	public String getMenuSubFTitle() {
		return menuSubFTitle;
	}
	public void setMenuSubFTitle(String menuSubFTitle) {
		this.menuSubFTitle = menuSubFTitle;
	}
	public String getMenuSubFContent() {
		return menuSubFContent;
	}
	public void setMenuSubFContent(String menuSubFContent) {
		this.menuSubFContent = menuSubFContent;
	}
	public String getMenuSubSTitle() {
		return menuSubSTitle;
	}
	public void setMenuSubSTitle(String menuSubSTitle) {
		this.menuSubSTitle = menuSubSTitle;
	}
	public String getMenuSContent() {
		return menuSContent;
	}
	public void setMenuSContent(String menuSContent) {
		this.menuSContent = menuSContent;
	}
	public String getMenuTTitle() {
		return menuTTitle;
	}
	public void setMenuTTitle(String menuTTitle) {
		this.menuTTitle = menuTTitle;
	}
	public String getMenuTContent() {
		return menuTContent;
	}
	public void setMenuTContent(String menuTContent) {
		this.menuTContent = menuTContent;
	}
	public String getMenuFootContent() {
		return menuFootContent;
	}
	public void setMenuFootContent(String menuFootContent) {
		this.menuFootContent = menuFootContent;
	}
	@Override
	public String toString() {
		return "MenuDTO [menuId=" + menuId + ", userId=" + userId + ", menuTitle=" + menuTitle + ", menuContent="
				+ menuContent + ", menuSubFTitle=" + menuSubFTitle + ", menuSubFContent=" + menuSubFContent
				+ ", menuSubSTitle=" + menuSubSTitle + ", menuSContent=" + menuSContent + ", menuTTitle=" + menuTTitle
				+ ", menuTContent=" + menuTContent + ", menuFootContent=" + menuFootContent + "]";
	}
	
	
}
