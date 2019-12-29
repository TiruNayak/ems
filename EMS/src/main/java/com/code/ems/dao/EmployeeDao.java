package com.code.ems.dao;

import java.util.List;

import com.code.ems.model.Employee;


public interface EmployeeDao {
	
	public Employee getEmployee(int empId);
	public List<Employee> getAllEmployees();
	public int addEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployee(int empId);
}
