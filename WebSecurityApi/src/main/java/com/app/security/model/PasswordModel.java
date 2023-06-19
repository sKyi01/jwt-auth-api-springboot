package com.app.security.model;

public class PasswordModel {
	private String email;
	private String oldPassword;
	private String newPassword;

	public String getEmail() {
		return email;
	}

	public PasswordModel(String email, String oldPassword, String newPassword) {
		super();
		this.email = email;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PasswordModel(String email) {
		super();
		this.email = email;
	}

	public PasswordModel() {
		super();
	}

	@Override
	public String toString() {
		return "PasswordModel [email=" + email + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword + "]";
	}
}
