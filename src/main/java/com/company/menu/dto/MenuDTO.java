package com.company.menu.dto;

import java.sql.Date;

public class MenuDTO {
	int menuId;
	String userId;
	String menuTitle;
	String menuContent;
	String menuSubFTitle;
	String menuSubFContent;
	String menuSubSTitle;
	String menuSubSContent;
	String menuSubTTitle;
	String menuSubTContent;
	String menuFootContent;
	Date menuDate;
	String gbsImg;
	String gbsThumbImg;
	int menuViewCnt;
	
	public int getMenuViewCnt() {
		return menuViewCnt;
	}
	public void setMenuViewCnt(int menuViewCnt) {
		this.menuViewCnt = menuViewCnt;
	}
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
	public String getMenuSubSContent() {
		return menuSubSContent;
	}
	public void setMenuSubSContent(String menuSubSContent) {
		this.menuSubSContent = menuSubSContent;
	}
	public String getMenuSubTTitle() {
		return menuSubTTitle;
	}
	public void setMenuSubTTitle(String menuSubTTitle) {
		this.menuSubTTitle = menuSubTTitle;
	}
	public String getMenuSubTContent() {
		return menuSubTContent;
	}
	public void setMenuSubTContent(String menuSubTContent) {
		this.menuSubTContent = menuSubTContent;
	}
	public String getMenuFootContent() {
		return menuFootContent;
	}
	public void setMenuFootContent(String menuFootContent) {
		this.menuFootContent = menuFootContent;
	}
	public Date getMenuDate() {
		return menuDate;
	}
	public void setMenuDate(Date menuDate) {
		this.menuDate = menuDate;
	}
	public String getGbsImg() {
		return gbsImg;
	}
	public void setGbsImg(String gbsImg) {
		this.gbsImg = gbsImg;
	}
	public String getGbsThumbImg() {
		return gbsThumbImg;
	}
	public void setGbsThumbImg(String gbsThumbImg) {
		this.gbsThumbImg = gbsThumbImg;
	}
	@Override
	public String toString() {
		return "MenuDTO [menuId=" + menuId + ", userId=" + userId + ", menuTitle=" + menuTitle + ", menuContent="
				+ menuContent + ", menuSubFTitle=" + menuSubFTitle + ", menuSubFContent=" + menuSubFContent
				+ ", menuSubSTitle=" + menuSubSTitle + ", menuSubSContent=" + menuSubSContent + ", menuSubTTitle=" + menuSubTTitle
				+ ", menuSubTContent=" + menuSubTContent + ", menuFootContent=" + menuFootContent + "]";
	}
	
	
}
