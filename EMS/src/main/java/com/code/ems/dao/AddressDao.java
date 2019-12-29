package com.code.ems.dao;

import com.code.ems.model.Address;
import com.code.ems.model.Employee;

public interface AddressDao {

	Address getEmployeeAddress(int empId);
	int addEmployeeAddress(Employee employee);
	
}
