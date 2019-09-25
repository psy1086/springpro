package com.company.like.dto;

public class LikeDTO {

	private int likeId;
	private int borderId;
	private String userId;
	private int likeCheck;
	public int getLikeId() {
		return likeId;
	}
	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}
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
	public int getLikeCheck() {
		return likeCheck;
	}
	public void setLikeCheck(int likeCheck) {
		this.likeCheck = likeCheck;
	}
	@Override
	public String toString() {
		return "LikeDTO [likeId=" + likeId + ", borderId=" + borderId + ", userId=" + userId + ", likeCheck="
				+ likeCheck + "]";
	}
	
	
}
