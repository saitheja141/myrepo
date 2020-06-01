package com.example.employeemangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemangement.GlobalException;
import com.example.employeemangement.model.Employee;
import com.example.employeemangement.service.IEmployeeService;
/**
 * This Rest controller mainly 
 * performs CRUD Operations 
 * on employees resource 
 * @author saitheja macharla
 *
 */
@RestController
public class EmployeesController {

	@Autowired
	IEmployeeService employeeService;
    /**
     * This method return list of all employees
     * and can be accessed by users with role admin and user
     * @return
     */
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		try {
			return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}

	}
    /**
     *This method will return specific employee based on their employee Id
     * and can be accessed by users with role admin and user
     * @param employeeId
     * @return
     */
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
		try {
			return new ResponseEntity<Employee>(employeeService.getEmployee(employeeId), HttpStatus.OK);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}
	}
    /**
     * This method will create a new employee
     * and can be accessed by users with role admin only
     * @param employee
     * @return
     */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Employee> saveEmployees(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}
	}
    /**
     * This method will update employee information 
     * and can be accessed by users with role admin only
     * @param employeeId
     * @param employee
     * @return
     */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
		try {
			return new ResponseEntity<Employee>(employeeService.updateEmployee(employeeId, employee), HttpStatus.OK);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}

	}
	
    /**
     * This method will delete employee
     * and can be accessed by users with role admin only  
     * @param employeeId
     * @return
     */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable int employeeId) {
		try {
			return new ResponseEntity<Boolean>(employeeService.deleteEmployee(employeeId), HttpStatus.OK);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}
	}

}
