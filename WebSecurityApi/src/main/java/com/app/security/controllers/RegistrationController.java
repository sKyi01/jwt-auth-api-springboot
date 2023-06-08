package com.app.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.security.entity.Employee;
import com.app.security.event.RegistrationCompleteEvent;
import com.app.security.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping("/registration")
	public String registerEmployee(@RequestBody Employee emp, HttpServletRequest request) {

		Employee e = new Employee(emp.getEmpName(), emp.getComName(), emp.getYearExperience(), emp.getEmail(),
				emp.getPassword());
		System.out.println("value you have given : " + emp);
		e.setEmpRole("USER");
		e.setEnabled(true);

		Employee e1 = empService.registerEmployee(e);
		System.out.println("e1 :" + e1);
		publisher.publishEvent(new RegistrationCompleteEvent(e1, applicationUrl(request)));
		return "success";
	}

	private String applicationUrl(HttpServletRequest request) {

		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}

}
