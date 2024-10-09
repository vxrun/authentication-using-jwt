package com.demo.project.service;

import com.demo.project.dto.LoginUserDTO;
import com.demo.project.dto.RegisterUserDTO;
import com.demo.project.entity.User;

public interface AuthenticationService {

	User signup(RegisterUserDTO registerUserDTO);

	User authenticate(LoginUserDTO loginUserDTO);

}
