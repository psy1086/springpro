package com.company.user.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.company.user.dto.LoginDTO;
import com.company.user.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.company.mapper.memberMapper";
	
	@Override
	public List<UserDTO> selectUser() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace+".selectUser");
	}

	@Override
	public int userRegister(UserDTO userDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(Namespace+".userRegister", userDTO);
	}
	
	@Override
	public UserDTO userLogin(LoginDTO loginDTO) throws Exception {
		return sqlSession.selectOne(Namespace+".userLogin", loginDTO);
	}
	
	@Override
	public int pwFind(Map map) throws Exception {
		return sqlSession.selectOne(Namespace+".pwFindAction", map);
	}
	
	@Override
	public void rePasswordAction(Map map) throws Exception {
		sqlSession.update(Namespace+".rePassword", map);
	}
}
