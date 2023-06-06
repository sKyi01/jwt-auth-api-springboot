package com.app.security.service;

import com.app.security.entity.Employee;
import com.app.security.model.EmployeeModel;

public interface EmployeeService {

	public Employee registerEmployee(EmployeeModel empModel);
}
