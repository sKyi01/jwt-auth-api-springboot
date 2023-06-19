package com.app.security.service;

import java.util.Optional;

import com.app.security.entity.Employee;
import com.app.security.entity.VerificationToken;

public interface EmployeeService {

	public Employee registerEmployee(Employee emp);

	public void saveVerificationTokenForEmployee(Employee emp, String token);

	public String validateVerificationToken(String token);

	public VerificationToken generateNewVerificationToken(String oldToken);

	public Employee findEmployeeByEmail(String email);

	public void createPasswordResetTokenForUser(Employee emp, String token);

	public String validatepasswordResetToken(String token);

	public Optional<Employee> getEmployeeByPasswordResetToken(String token);

	public void changePassword(Employee employee, String newPassword);

	public boolean checkValidOldPassword(Employee emp, String oldPassword);

}
