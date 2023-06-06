package com.app.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.security.entity.Employee;
import com.app.security.model.EmployeeModel;
import com.app.security.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Employee registerEmployee(EmployeeModel empModel) {
		Employee emp= new Employee();
		emp.setEmail(empModel.getEmail());
		emp.setComName(empModel.getComName());
		emp.setEmpName(emp.getEmpName());
		emp.setEmpRole("USER");
		emp.setPassword(passwordEncoder.encode(empModel.getPassword()));
		emp.setYearExperience(empModel.getYearExperience());

		empRepository.save(emp);



		return null;
	}

}
