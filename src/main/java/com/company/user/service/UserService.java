package com.company.user.service;

import java.util.List;

import com.company.user.dto.UserDTO;

public interface UserService {

	public List<UserDTO> selectUser() throws Exception;
	public int userRegister(UserDTO userDTO) throws Exception;
	
}
