package com.code.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.code.ems.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setFirstName(rs.getString("first_name"));
		employee.setLastName(rs.getString("last_name"));
		employee.setEmail(rs.getString("email"));
		employee.setPhoneNumber(rs.getString("phone_number"));
		employee.setRole(rs.getString("role"));
		employee.setYearsOfExperience(rs.getInt("years_of_experience"));
		return employee;
	}

}
