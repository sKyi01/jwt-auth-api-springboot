package com.app.security.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

import com.app.security.entity.Employee;

public class RegistrationCompleteEvent extends ApplicationEvent {

	@Autowired
	private Employee emp;

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getApplicationUrl() {
		return applicationUrl;
	}

	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}

	private String applicationUrl;

	public RegistrationCompleteEvent(Employee emp, String applicationUrl) {
		super(emp);
		System.out.println(emp);
		System.out.println(applicationUrl);
		this.emp = emp;
		this.applicationUrl = applicationUrl;
	}

}
