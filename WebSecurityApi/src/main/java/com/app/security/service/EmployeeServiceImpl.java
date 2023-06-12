package com.app.security.service;

import java.util.Calendar;
import java.util.UUID;

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

	@Override
	public String validateVerificationToken(String token) {
		VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
		if (verificationToken == null) {
			return "invalid";

		}
		Employee emp = verificationToken.getEmp();
		Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpirationTime().getTime() - cal.getTime().getTime()) <= 0) {
			verificationTokenRepository.delete(verificationToken);
			return "Expired";
		}
		emp.setEnabled(true);
		empRepository.save(emp);
		return "Valid";
	}

	@Override
	public VerificationToken generateNewVerificationToken(String oldToken) {
		System.out.println("generated function token : " + oldToken);
		VerificationToken verificationToken = verificationTokenRepository.findByToken(oldToken);
		System.out.println("object printing :" + verificationToken);
		verificationToken.setToken(UUID.randomUUID().toString());
		System.out.println("New Updated Token : " + verificationToken.getToken());
		verificationTokenRepository.save(verificationToken);

		return verificationToken;
	}

}
