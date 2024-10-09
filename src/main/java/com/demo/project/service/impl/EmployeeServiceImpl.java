package com.demo.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.project.entity.User;
import com.demo.project.repository.UserRepository;
import com.demo.project.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private UserRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User registerEmployee(User employee) {
		String password = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(password);
		employeeRepository.save(employee);
		return null;
	}

}
