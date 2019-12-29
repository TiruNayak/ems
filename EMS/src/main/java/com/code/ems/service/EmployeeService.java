package com.code.ems.service;

import java.util.List;

import com.code.ems.model.Employee;

public interface EmployeeService {

	public Employee getEmployee(int empId);
	public List<Employee> getAllEmployees();
	public Employee addEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployee(int empId);
}
