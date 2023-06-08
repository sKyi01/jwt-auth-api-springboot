package com.app.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String empName;
	private String comName;

	public Employee(String empName, String comName, int yearExperience, String email, String password) {
		super();
		this.empName = empName;
		this.comName = comName;
		this.yearExperience = yearExperience;
		this.email = email;
		this.password = password;
	}

	private int yearExperience;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", comName=" + comName + ", yearExperience="
				+ yearExperience + ", email=" + email + ", password=" + password + ", enabled=" + enabled + ", empRole="
				+ empRole + "]";
	}

	public Employee(Long id, String empName, String comName, int yearExperience, String email, String password,
			boolean enabled, String empRole) {
		super();
		this.id = id;
		this.empName = empName;
		this.comName = comName;
		this.yearExperience = yearExperience;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.empRole = empRole;
	}

	public Employee(String empName, String comName, int yearExperience, String email, String password, boolean enabled,
			String empRole) {
		super();
		this.empName = empName;
		this.comName = comName;
		this.yearExperience = yearExperience;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.empRole = empRole;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public int getYearExperience() {
		return yearExperience;
	}

	public void setYearExperience(int yearExperience) {
		this.yearExperience = yearExperience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	private String email;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String password;
	private boolean enabled = false;
	private String empRole;

}
