package com.company.user.service;

import java.util.List;
import java.util.Map;

import com.company.user.dto.LoginDTO;
import com.company.user.dto.UserDTO;

public interface UserService {

	public List<UserDTO> selectUser() throws Exception;
	public int userRegister(UserDTO userDTO) throws Exception;
	public UserDTO userLogin(LoginDTO loginDTO) throws Exception;
	public int pwFind(Map map) throws Exception;
}
