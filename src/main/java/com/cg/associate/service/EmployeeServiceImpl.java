package com.cg.associate.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.associate.dao.EmployeeRepository;
import com.cg.associate.entity.Employee;
import com.cg.associate.exception.EmployeeNotFoundException;
import com.cg.associate.exception.InvalidEmpIdException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
			return employeeRepository.save(employee);
			
	}

	@Override
	public String deleteEmployee(long empId) {
		if(empId>0) {
			Optional<Employee> employeeById = employeeRepository.findById(empId);
			if(employeeById.isPresent()) {
				employeeRepository.delete(employeeById.get());
				return "Employee record deleted";
			}else
				throw new EmployeeNotFoundException("Employee not found");
		}else
			throw new InvalidEmpIdException("!! Invalid Emp ID !!");
		
	}

	
	@Override
	public List<Employee> findByAge(int empAge) {
		return employeeRepository.findByEmpAge(empAge);
	}

	@Override
	public List<Employee> findByAgeAndCode(int empAge, int countryCode) {
		return employeeRepository.findByEmpAgeAndCountryCode(empAge, countryCode);
	}

	@Override
	public String updateEmployee(Employee employee) {
		Optional<Employee> employeeById = employeeRepository.findById(employee.getEmpId());
		if(employeeById.isPresent()) {
			Employee updatedEmployee = employeeById.get();
			updatedEmployee.setEmpName(employee.getEmpName());
			updatedEmployee.setEmpAge(employee.getEmpAge());
			updatedEmployee.setCountryCode(employee.getCountryCode());
			updatedEmployee.setAddress(employee.getAddress());
			employeeRepository.save(updatedEmployee);
			return "Employee details updated";
		}else 
			return "Employee not found";
	}

	@Override
	public List<Employee> viewEmployee() {
		return employeeRepository.findAll();
	}
	
}
