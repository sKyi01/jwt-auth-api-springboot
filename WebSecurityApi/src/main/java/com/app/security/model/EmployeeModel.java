package com.app.security.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
	private String empName;

	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeModel(String empName, String comName, int yearExperience, String email, String password,
			String matchingPassword) {
		super();
		this.empName = empName;
		this.comName = comName;
		this.yearExperience = yearExperience;
		this.email = email;
		this.password = password;
		this.matchingPassword = matchingPassword;
	}

	@Override
	public String toString() {
		return "EmployeeModel [empName=" + empName + ", comName=" + comName + ", yearExperience=" + yearExperience
				+ ", email=" + email + ", password=" + password + ", matchingPassword=" + matchingPassword + "]";
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

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	private String comName;
	private int yearExperience;
	private String email;

	private String password;
	private String matchingPassword;

}
