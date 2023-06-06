package com.app.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.security.entity.Employee;
import com.app.security.event.RegistrationCompleteEvent;
import com.app.security.model.EmployeeModel;
import com.app.security.service.EmployeeService;

@RestController
public class RegistrationController {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping("/register")
	public String registerEmployee(@RequestBody EmployeeModel empModel) {
		Employee emp = empService.registerEmployee(empModel);
		publisher.publishEvent(new RegistrationCompleteEvent(emp, "url"));
		return "success";
	}

}
