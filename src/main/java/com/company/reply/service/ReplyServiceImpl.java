package com.company.reply.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.border.main.Criteria;
import com.company.reply.dao.ReplyDAO;
import com.company.reply.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO replyDAO;
	
	@Override
	public List<ReplyDTO> replyList(int borderId) throws Exception {
		// TODO Auto-generated method stub
		return replyDAO.replyList(borderId);
	}

	@Override
	public int replyWrite(ReplyDTO replyDTO) throws Exception {
		// TODO Auto-generated method stub
		return replyDAO.replyWrite(replyDTO);
	}

	@Override
	public int replyUpdate(ReplyDTO replyDTO) throws Exception {
		// TODO Auto-generated method stub
		return replyDAO.replyUpdate(replyDTO);
	}

	@Override
	public int replyDelete(int replyId) throws Exception {
		// TODO Auto-generated method stub
		return replyDAO.replyDelete(replyId);
	}

	@Override
	public int replyCnt(int borderId) throws Exception {
		// TODO Auto-generated method stub
		return replyDAO.replyCnt(borderId);
	}

}
