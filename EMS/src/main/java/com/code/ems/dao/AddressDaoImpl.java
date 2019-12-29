package com.code.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.code.ems.model.Address;
import com.code.ems.model.Employee;

@Repository
public class AddressDaoImpl implements AddressDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	String GET_EMP_ADDRRESS = "select * from emp_address where emp_id = ?" ;
	String ADD_EMP_ADDRESS = "insert into emp_address values(?,?,?,?,?)";
	
	public Address getEmployeeAddress(int empId) {
		return  jdbcTemplate.queryForObject(GET_EMP_ADDRRESS, 
											new Object[] {empId}, 
											new AddressMapper());
	}

	public int addEmployeeAddress(Employee employee) {
		Address address=employee.getAddress();
		return jdbcTemplate.update(ADD_EMP_ADDRESS,
									employee.getId(),
									address.getCity(),
									address.getState(),
									address.getCountry(),
									address.getPincode()
									);
	}
	
	private static final class AddressMapper implements RowMapper<Address>{

		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
			Address address = new Address();
			address.setCity(rs.getString("city"));
			address.setState(rs.getString("state"));
			address.setCountry(rs.getString("country"));
			address.setPincode(rs.getInt("pincode"));
			
			return address;
		}
		
	}

}
