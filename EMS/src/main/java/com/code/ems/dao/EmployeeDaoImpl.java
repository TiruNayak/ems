package com.code.ems.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.code.ems.model.Employee;

@Repository
@PropertySource("classpath:ems-sql-queries.properties")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
    private Environment env;
	
	String GET_EMPLOYEE = "select * from employee where id = ?";
	//String GET_ALL_EMPLOYEES = "select * from employee";
	String CREATE_EMPLOYEE = "insert into employee value(?,?,?,?,?,?,?)";

	public Employee getEmployee(int empId) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE, 
											new Object[] {empId},
											new EmployeeRowMapper());
	}

	public List<Employee> getAllEmployees() {
		return  jdbcTemplate.query(env.getProperty("EMPLOYEE.GET.ALLEMPLOYESS"), 
									new EmployeeRowMapper());	
	}

	public int addEmployee(Employee employee) {
		return jdbcTemplate.update(CREATE_EMPLOYEE,
									employee.getId(),
									employee.getFirstName(),
									employee.getLastName(),
									employee.getEmail(),
									employee.getPhoneNumber(),
									employee.getYearsOfExperience(),
									employee.getRole()
									);
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
