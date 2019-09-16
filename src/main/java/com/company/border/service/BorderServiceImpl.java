package com.company.border.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.border.dao.BorderDAO;
import com.company.border.dto.BorderDTO;

@Service
public class BorderServiceImpl implements BorderService {

	@Inject
	private BorderDAO borderDAO;
	
	@Override
	public List<BorderDTO> borderList() throws Exception {
		// TODO Auto-generated method stub
		return borderDAO.borderList();
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

}
