package com.company.border.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.company.border.dao.BorderDAO;
import com.company.border.dto.BorderDTO;
import com.company.border.main.Criteria;

@Service
public class BorderServiceImpl implements BorderService {

	@Inject
	private BorderDAO borderDAO;
	
	@Override
	public List<BorderDTO> borderList(Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return borderDAO.borderList(criteria);
	}

	@Override
	public int borderWrite(BorderDTO borderDTO) throws Exception {
		// TODO Auto-generated method stub
		return borderDAO.borderWrite(borderDTO);
	}

	@Override
	public int borderUpdate(BorderDTO borderDTO) throws Exception {
		// TODO Auto-generated method stub
		return borderDAO.borderUpdate(borderDTO);
	}

	@Override
	public int borderDelete(int borderId) throws Exception {
		// TODO Auto-generated method stub
		return borderDAO.borderDelete(borderId);
	}

	@Override
	public int borderLike(int borderId) throws Exception {
		// TODO Auto-generated method stub
		return borderDAO.borderLike(borderId);
	}

	@Override
	public BorderDTO borderView(int borderId) throws Exception {
		// TODO Auto-generated method stub
		return borderDAO.borderView(borderId);
	}
	
	@Override
	public int borderCnt(Criteria criteria) throws Exception {
		return borderDAO.borderCnt(criteria);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BorderDTO borderViewCnt(int borderId) throws Exception {
		borderDAO.borderViewCnt(borderId);
		return borderDAO.borderView(borderId);
	}
	
	@Override
	public void replyCnt(int borderId) throws Exception {
		borderDAO.replyCnt(borderId);
	}
	
	
}
