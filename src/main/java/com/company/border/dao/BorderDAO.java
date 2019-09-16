package com.company.border.dao;

import java.util.List;

import com.company.border.dto.BorderDTO;

public interface BorderDAO {
	
	public List<BorderDTO> borderList() throws Exception;
	public int borderWrite(BorderDTO borderDTO) throws Exception;
	public int borderUpdate(BorderDTO borderDTO) throws Exception;
	public int borderDelete(int borderId) throws Exception;
	public int borderLike(int borderId) throws Exception;
	public BorderDTO borderView(int borderId) throws Exception;
	
}