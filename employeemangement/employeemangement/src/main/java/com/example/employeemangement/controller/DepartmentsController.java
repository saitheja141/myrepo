package com.example.employeemangement.controller;

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
import com.example.employeemangement.model.Department;
import com.example.employeemangement.service.IDepartmentsService;
/**
 * This Rest controller mainly 
 * performs CRUD Operations 
 * on departments resource 
 * @author saitheja macharla
 *
 */
@RestController
public class DepartmentsController {

	@Autowired
	IDepartmentsService departmentService;
    /**
     * This method will return specific department information  
     * @param departmentId
     * and can be accessed by users with role admin only
     * @return
     */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/departments/{departmentId}", method = RequestMethod.GET)
	public ResponseEntity<Department> getDepartment(@PathVariable int departmentId) {
		try {
			return new ResponseEntity<Department>(departmentService.getDepartment(departmentId), HttpStatus.OK);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}
	}
    /**
     * This method will create a new department
     * @param department
     * and can be accessed by users with role admin only
     * @return
     */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/departments", method = RequestMethod.POST)
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		try {
			return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}
	}
    /**
     * This method will update department information
     * and can be accessed by users with role admin only 
     * @param departmentId
     * @param department
     * @return
     */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/departments/{departmentId}", method = RequestMethod.PUT)
	public ResponseEntity<Department> updateDepartment(@PathVariable int departmentId,
			@RequestBody Department department) {
		try {
			return new ResponseEntity<Department>(departmentService.updateDepartment(departmentId, department),
					HttpStatus.OK);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}

	}
    /**
     * This method will delete department
     * and can be accessed by users with role admin only
     * @param departmentId
     * @return
     */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/departments/{departmentId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteDepartment(@PathVariable int departmentId) {
		try {
			return new ResponseEntity<Boolean>(departmentService.deleteDepartment(departmentId), HttpStatus.OK);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}

	}

}
