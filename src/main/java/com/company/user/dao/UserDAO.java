package com.company.user.dao;

import java.util.List;

import com.company.user.dto.UserDTO;
import com.company.user.dto.LoginDTO;

public interface UserDAO {

	public List<UserDTO> selectUser() throws Exception;
	public int userRegister(UserDTO userDTO) throws Exception;
//	public UserDTO userLogin(UserDTO userDTO) throws Exception;
	public UserDTO userLogin(LoginDTO loginDTO) throws Exception;
}
