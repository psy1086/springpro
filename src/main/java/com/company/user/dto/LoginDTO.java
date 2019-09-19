package com.company.user.dto;

public class LoginDTO {
	private String userId;
	private String userPassword;
	private boolean userCookie;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isUserCookie() {
		return userCookie;
	}
	public void setUserCookie(boolean userCookie) {
		this.userCookie = userCookie;
	}
	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", userPassword=" + userPassword + ", userCookie=" + userCookie + "]";
	}
	
	
}
