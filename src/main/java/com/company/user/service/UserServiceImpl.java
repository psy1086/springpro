package com.company.user.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.user.dao.UserDAO;
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

}
