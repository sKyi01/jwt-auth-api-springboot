package com.app.security.event.listener;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.app.security.entity.Employee;
import com.app.security.event.RegistrationCompleteEvent;
import com.app.security.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

	@Autowired
	private EmployeeService empService;

	private static final Logger logger = LoggerFactory.getLogger(Employee.class);

	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		// Create the Verification Token for the User with Link

		Employee emp = event.getEmp();
		String token = UUID.randomUUID().toString();
		System.out.println("listener emp : " + emp);
		System.out.println("listener token : " + token);
		empService.saveVerificationTokenForEmployee(emp, token);

		// Send Mail to Employee

		String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;

		// send verification Email
		logger.info("click the link to verify your account : " + url);

		System.out.println("listener url : " + url);
	}

}
