package com.demo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project.dto.LoginUserDTO;
import com.demo.project.dto.RegisterUserDTO;
import com.demo.project.entity.User;
import com.demo.project.service.AuthenticationService;
import com.demo.project.service.JwtService;
import com.demo.project.utils.LoginResponse;

@RequestMapping("/auth")
@RestController
public class AuthController {
	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/signup")
	public ResponseEntity<User> register(
			@RequestBody RegisterUserDTO registerUserDto) {
		User registeredUser = authenticationService.signup(registerUserDto);

		return ResponseEntity.ok(registeredUser);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(
			@RequestBody LoginUserDTO loginUserDto) {
		User authenticatedUser = authenticationService
				.authenticate(loginUserDto);

		String jwtToken = jwtService.generateToken(authenticatedUser);

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setToken(jwtToken);
		loginResponse.setExpiresIn(jwtService.getExpirationTime());

		return ResponseEntity.ok(loginResponse);
	}
}
