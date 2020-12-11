package com.cg.associate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.associate.entity.Employee;
import com.cg.associate.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long empId) {
		return new ResponseEntity<>(employeeService.deleteEmployee(empId), HttpStatus.OK);
	}
	
	@GetMapping("/viewEmployee")
	public ResponseEntity<List<Employee>> viewEmp(){
		return new ResponseEntity<>(employeeService.viewEmployee(), HttpStatus.OK);
	}
	
	@GetMapping("/viewByAge/age/{age}")
	public ResponseEntity<List<Employee>> viewByAge(@PathVariable int age){
		return new ResponseEntity<>(employeeService.findByAge(age), HttpStatus.OK);
	}
	
	@GetMapping("viewByAgeAndCode/age/{age}/code/{code}")
	public ResponseEntity<List<Employee>> viewByAgeAndCode(@PathVariable int age, @PathVariable int code){
		return new ResponseEntity<>(employeeService.findByAgeAndCode(age, code), HttpStatus.OK);
	}
}
