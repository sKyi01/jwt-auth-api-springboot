package com.app.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.security.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee,Long>{

}
