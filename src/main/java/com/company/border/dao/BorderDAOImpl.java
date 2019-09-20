package com.company.border.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.company.border.dto.BorderDTO;
import com.company.user.dto.UserDTO;
@Repository
public class BorderDAOImpl implements BorderDAO {

	private static final Logger logger = LoggerFactory.getLogger(BorderDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.company.mapper.borderMapper";
	
	@Override
	public List<BorderDTO> borderList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace+".borderList");
	}

	@Override
	public int borderWrite(BorderDTO borderDTO) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.insert(Namespace+".borderWrite", borderDTO);
	}

	@Override
	public int borderUpdate(BorderDTO borderDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(Namespace+".borderUpdate",borderDTO);
	}

	@Override
	public int borderDelete(int borderId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(Namespace+".borderDelete",borderId);
	}

	@Override
	public int borderLike(int borderId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(Namespace+".borderLike",borderId);
	}

	@Override
	public BorderDTO borderView(int borderId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+".borderView", borderId);
	}

}
