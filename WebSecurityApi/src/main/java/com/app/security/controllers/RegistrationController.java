package com.app.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.security.entity.Employee;
import com.app.security.entity.VerificationToken;
import com.app.security.event.RegistrationCompleteEvent;
import com.app.security.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(Employee.class);

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

	@GetMapping("verifyRegistration")
	public String verifyRegistration(@RequestParam("token") String token) {
		String result = empService.validateVerificationToken(token);
		if (result.equalsIgnoreCase("valid")) {
			return "Employee Verified Successfully";
		} else {
			return "Bad User";
		}

	}

	@GetMapping("/resendVerificationToken")
	public String resendVerificationToken(@RequestParam("token") String token, HttpServletRequest request) {
		System.out.println("resend token :- " + token);
		VerificationToken verificationToken = empService.generateNewVerificationToken(token);
		Employee emp = verificationToken.getEmp();
		System.out.println(emp);
		resendVerificationTokenMail(emp, applicationUrl(request), verificationToken);
		return "verification link sent";
	}

	private void resendVerificationTokenMail(Employee emp, String applicationUrl, VerificationToken verificationToken) {

		String url = applicationUrl + "resendVerificationToken?oldToken=" + verificationToken.getToken();
		System.out.println("Resend token generated : " + url);

		logger.info("click the link to verify your account : " + url);

	}

	private String applicationUrl(HttpServletRequest request) {

		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
	}

}
