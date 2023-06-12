package com.app.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.security.entity.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	@Query("SELECT vt FROM VerificationToken vt WHERE vt.token = :token")
	VerificationToken findByToken(String token);

}
