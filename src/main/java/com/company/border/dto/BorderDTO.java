package com.company.border.dto;

import java.util.Date;

public class BorderDTO {
	private int borderId;
	private String userId;
	private String borderTitle;
	private String borderContent;
	private Date borderDate;
	private int borderLike;
	
	public int getBorderId() {
		return borderId;
	}
	public void setBorderId(int borderId) {
		this.borderId = borderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBorderTitle() {
		return borderTitle;
	}
	public void setBorderTitle(String borderTitle) {
		this.borderTitle = borderTitle;
	}
	public String getBorderContent() {
		return borderContent;
	}
	public void setBorderContent(String borderContent) {
		this.borderContent = borderContent;
	}
	public Date getBorderDate() {
		return borderDate;
	}
	public void setBorderDate(Date borderDate) {
		this.borderDate = borderDate;
	}
	public int getBorderLike() {
		return borderLike;
	}
	public void setBorderLike(int borderLike) {
		this.borderLike = borderLike;
	}
	
	
}
