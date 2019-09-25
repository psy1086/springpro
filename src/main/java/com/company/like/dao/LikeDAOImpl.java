package com.company.like.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.company.like.dto.LikeDTO;

public class LikeDAOImpl implements LikeDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.company.mapper.borderMapper";
	
	@Override
	public void likeCreate(LikeDTO likeDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void likeInsert(int borderId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void likeDelete(int borderId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void likeCheck(int borderId) throws Exception {
		// TODO Auto-generated method stub

	}

}
