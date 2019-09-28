package com.company.reply.service;

import java.util.List;

import com.company.border.main.Criteria;
import com.company.reply.dto.ReplyDTO;

public interface ReplyService {
	public List<ReplyDTO> replyList(int borderId) throws Exception;
	public int replyWrite(ReplyDTO replyDTO) throws Exception;
	public int replyUpdate(ReplyDTO replyDTO) throws Exception;
	public int replyDelete(int replyId) throws Exception;
	public int replyCnt(int borderId) throws Exception;
}
