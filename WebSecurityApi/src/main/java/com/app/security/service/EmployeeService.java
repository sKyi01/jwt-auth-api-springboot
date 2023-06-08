package com.app.security.service;

import com.app.security.entity.Employee;

public interface EmployeeService {

	public Employee registerEmployee(Employee emp);

	public void saveVerificationTokenForEmployee(Employee emp, String token);
}
