package com.cg.associate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.associate.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByEmpAge(int empAge);
	List<Employee> findByEmpAgeAndCountryCode(int empAge, int countryCode);
}
