package com.app.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.security.entity.Employee;
import com.app.security.entity.VerificationToken;
import com.app.security.repositories.EmployeeRepository;
import com.app.security.repositories.VerificationTokenRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Override
	public Employee registerEmployee(Employee emp) {

		System.out.println("employee valu : " + emp);
		emp.setPassword(passwordEncoder.encode(emp.getPassword()));

		empRepository.save(emp);

		return emp;
	}

	@Override
	public void saveVerificationTokenForEmployee(Employee emp, String token) {

		VerificationToken verificationToken = new VerificationToken(emp, token);
		verificationTokenRepository.save(verificationToken);

	}

}
