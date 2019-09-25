package com.company.like.dao;

import com.company.like.dto.LikeDTO;

public interface LikeDAO {

	public void likeCreate(LikeDTO likeDTO) throws Exception;
	public void likeInsert(int borderId) throws Exception;
	public void likeDelete(int borderId) throws Exception;
	public void likeCheck(int borderId) throws Exception;
}
