package com.example.employeemangement.service;

import com.example.employeemangement.model.Department;
/**
 * This interface has been implemented by DepartmentService
 * @author saitheja macharla
 *
 */
public interface IDepartmentsService {

	public Department saveDepartment(Department department);
	public Department updateDepartment(int departmentId,Department department);
	public boolean deleteDepartment(int departmentId);
	public Department getDepartment(int departmentId);
}
