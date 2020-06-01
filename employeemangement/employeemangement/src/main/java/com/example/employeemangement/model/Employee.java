package com.example.employeemangement.model;

public class Employee {
	
	private int employeeId;
	private Department department;
	private String firstName;
	private String lastName;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Employee(int employeeId, Department department, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.department = department;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
	public Employee() {
		super();
	}
	
	
	

}
