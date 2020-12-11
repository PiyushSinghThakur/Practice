package com.cg.associate.service;

import java.util.List;

import com.cg.associate.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	public List<Employee> viewEmployee();
	public String updateEmployee(Employee employee);
	public String deleteEmployee(long empId);
	public List<Employee> findByAge(int empAge);
	public List<Employee> findByAgeAndCode(int empAge, int countryCode);
}
