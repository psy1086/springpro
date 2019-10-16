package com.company.user.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.user.dao.UserDAO;
import com.company.user.dto.LoginDTO;
import com.company.user.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO userDAO;
	
	@Override
	public List<UserDTO> selectUser() throws Exception {
		// TODO Auto-generated method stub
		return userDAO.selectUser();
	}

	@Override
	public int userRegister(UserDTO userDTO) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.userRegister(userDTO);
	}

	@Override
	public UserDTO userLogin(LoginDTO loginDTO) throws Exception {
		return userDAO.userLogin(loginDTO);
	}
	
	@Override
	public int pwFind(Map map) throws Exception {
		return userDAO.pwFind(map);
	}

	@Override
	public void rePasswordAction(Map map) throws Exception {
		userDAO.rePasswordAction(map);
	}
}
