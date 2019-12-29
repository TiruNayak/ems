package com.code.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.ems.dao.AddressDao;
import com.code.ems.dao.EmployeeDao;
import com.code.ems.dao.SkillDao;
import com.code.ems.model.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	SkillDao skillDao;
	
	@Autowired
	SkillService skillService;
	

	@Transactional
	public Employee getEmployee(int empId) {
		Employee employee = employeeDao.getEmployee(empId);
		employee.setAddress(addressDao.getEmployeeAddress(employee.getId()));
		employee.setSkills(skillDao.getSkills(employee.getId()));
		return employee;
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		List<Employee> empList = employeeDao.getAllEmployees();
		for(Employee emp: empList) {
			emp.setSkills(skillDao.getSkills(emp.getId()));
			emp.setAddress(addressDao.getEmployeeAddress(emp.getId()));
		}
		return empList;
	}

	@Transactional
	public Employee addEmployee(Employee employee) {
		System.out.println("EmployeeService: in addEmployee method");
		employeeDao.addEmployee(employee);
		System.out.println("EmployeeService: before calling addEmployeeAddress method");
		addressDao.addEmployeeAddress(employee);
		System.out.println("EmployeeService: before calling SkillService addSkills method");
		skillService.addSkills(employee.getSkills());
		System.out.println("EmployeeService: before calling getEmployee method");
		return employeeDao.getEmployee(employee.getId());
	}

	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
