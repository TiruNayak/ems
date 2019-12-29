package com.code.ems.controller;

import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.ems.model.Employee;
import com.code.ems.service.EmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;
	
	public static Logger logger = LoggerFactory.getLogger(EmployeeRestController.class); 
	
	@GetMapping("/ems/employee")
	public List<Employee> getAllEmployee( ) {
		return employeeService.getAllEmployees();
		
	}
	
	@GetMapping("/ems/employee/{empId}")
	public Employee getEmployee(@PathVariable int empId) {
		logger.info("Controller: AddEmployee method, " + empId);
		return employeeService.getEmployee(empId);
	}
	
	@PostMapping("/ems/employee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee, BindingResult result) throws NoSuchMethodException, SecurityException, MethodArgumentNotValidException { 
		logger.info("Controller: AddEmployee method, " + employee);
		if (result.hasErrors()) {
			throw new MethodArgumentNotValidException(new MethodParameter(Employee.class.getConstructor(),0), result);
		
		}
		
		employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeService.getEmployee(employee.getId()),HttpStatus.OK);
		
	}
}
