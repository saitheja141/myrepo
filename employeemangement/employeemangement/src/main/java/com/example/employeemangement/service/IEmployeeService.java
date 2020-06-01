package com.example.employeemangement.service;

import java.util.List;

import com.example.employeemangement.model.Employee;
/***
 * This interface has been implemented by EmployeeService
 * @author saitheja macharla
 *
 */
public interface IEmployeeService {
	public Employee saveEmployee(Employee employee);
	public Employee updateEmployee(int employeeId,Employee employee);
	public Employee getEmployee(int employeeId);
	public List<Employee> getAllEmployees();
	public boolean deleteEmployee(int employeeId);
}
