package com.app.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private long id;
	private String empName;
	private String comName;
	private int yearExperience;
	private boolean enabled=false;
	private String empRole;
	
	
	
	
}
