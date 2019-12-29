package com.code.ems.model;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.code.ems.utils.Phone;

public class Employee {

	@NotNull(message="Employee.id cann't be null")
	@Min(1)
	private int id;
	
	@NotNull(message="Employee.firstName cannot be null")
	//@Size(min=1,max=30)
	private String firstName;
	
	@NotNull(message="Employee.lastName cannot be null")
	@Size(min=1,max=30)
	private String lastName;
	private String email;
	
	@Phone
	private String phoneNumber;
	private int yearsOfExperience;
	
	@NotNull(message="Employee.phoneNumber cann't be null")
	@Min(1)
	private String role;
	
	private Address address;
	private List<Skill> skills;
	
	public Employee() {}

	public Employee(int id, String firstName, String lastName, String email, String phoneNumber, int yearsOfExperience,
			String role, List<Skill> skills, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.yearsOfExperience = yearsOfExperience;
		this.role = role;
		this.skills = skills;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber (String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", experience=" + yearsOfExperience + ", role=" + role + ", skills="
				+ skills + ", address=" + address + "]";
	}


}
