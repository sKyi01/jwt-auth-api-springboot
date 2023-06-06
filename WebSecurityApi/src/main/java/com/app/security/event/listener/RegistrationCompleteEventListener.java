package com.app.security.event.listener;

import java.util.UUID;

import org.springframework.context.ApplicationListener;

import com.app.security.entity.Employee;
import com.app.security.event.RegistrationCompleteEvent;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		// Create the Verification Token for the User with Link

		Employee emp=event.getEmp();
		String token=UUID.randomUUID().toString();

		// Send Mail to Employee
	}

}
