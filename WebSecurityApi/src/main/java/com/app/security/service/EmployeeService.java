package com.app.security.service;

import com.app.security.entity.Employee;
import com.app.security.entity.VerificationToken;

public interface EmployeeService {

	public Employee registerEmployee(Employee emp);

	public void saveVerificationTokenForEmployee(Employee emp, String token);

	public String validateVerificationToken(String token);

	public VerificationToken generateNewVerificationToken(String oldToken);

}
