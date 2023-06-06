package com.app.security.entity;

import java.util.Date;
import java.util.Calendar;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class VerificationToken {
	
	//Expiration time is 10 minutes
	
	private static final int EXPIRATION_TIME=10;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String token;

	private Date expirationTime;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
	private Employee emp;
	
	public VerificationToken(Employee emp,String token) {
		super();
		this.token=token;
		this.emp=emp;
		this.expirationTime= calculateExpirationDate(EXPIRATION_TIME);
	}

	public VerificationToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VerificationToken(String token) {
		super();
		this.token=token;
		this.expirationTime=calculateExpirationDate(EXPIRATION_TIME);
		
	}
	
	
	 private Date calculateExpirationDate(int expirationTime) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTimeInMillis(new Date().getTime());
	        calendar.add(Calendar.MINUTE, expirationTime);
	        return new Date(calendar.getTime().getTime());
	    }

}
