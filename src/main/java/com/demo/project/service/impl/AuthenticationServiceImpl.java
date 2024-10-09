package com.demo.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.project.dto.LoginUserDTO;
import com.demo.project.dto.RegisterUserDTO;
import com.demo.project.entity.User;
import com.demo.project.repository.UserRepository;
import com.demo.project.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public User signup(RegisterUserDTO registerUserDTO) {
		User newUser = new User();
		newUser.setFullName(registerUserDTO.getFullName());
		newUser.setEmail(registerUserDTO.getEmail());
		newUser.setPassword(
				passwordEncoder.encode(registerUserDTO.getPassword()));
		return userRepository.save(newUser);

	}

	@Override
	public User authenticate(LoginUserDTO loginUserDTO) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUserDTO.getEmail(),
						loginUserDTO.getPassword()));
		return userRepository.findByEmail(loginUserDTO.getEmail())
				.orElseThrow();
	}

}
