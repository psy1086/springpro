package com.company.reply.dto;

import java.sql.Date;

public class ReplyDTO {
	
	private int replyId;
	private int borderId;
	private String userId;
	private String replyContent;
	private Date replyDate;
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
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
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	@Override
	public String toString() {
		return "ReplyDTO [replyId=" + replyId + ", borderId=" + borderId + ", userId=" + userId + ", replyContent="
				+ replyContent + ", replyDate=" + replyDate + "]";
	}
	
	

}
