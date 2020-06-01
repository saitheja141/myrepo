package com.example.employeemangement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemangement.GlobalException;
import com.example.employeemangement.model.Department;
import com.example.employeemangement.model.DepartmentEntity;
import com.example.employeemangement.model.Employee;
import com.example.employeemangement.model.EmployeeEntity;
import com.example.employeemangement.model.Language;
import com.example.employeemangement.repository.IDepartmentsRepo;
import com.example.employeemangement.repository.IEmployeesRepo;
/*
 * This class mainly deals
 * with service operations related 
 * to employee resources 
 */
@Service
@Transactional
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployeesRepo employeeRepo;

	@Autowired
	IDepartmentsRepo departmentRepo;
    /**
     * This method creates a new employee
     * 
     */
	@Override
	public Employee saveEmployee(Employee employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.department_id = employee.getDepartment().getDepartmentId();
		employeeEntity.firstName = employee.getFirstName();
		employeeEntity.lastName = employee.getLastName();
		employeeEntity.employee_id = employee.getEmployeeId();
		employeeEntity = employeeRepo.save(employeeEntity);
		return getEmployee(employeeEntity.employee_id);
	}
    /**
     * This method update employee information
     */
	@Override
	public Employee updateEmployee(int employeeId, Employee employee) {
		EmployeeEntity employeeEntity = employeeRepo.findById(employeeId).orElse(null);
		if (!Objects.isNull(employeeEntity)) {
			employee.setEmployeeId(employeeId);
			return saveEmployee(employee);
		} else {
			throw new GlobalException("No Employee Found");
		}

	}
    /**
     * This method fetches employee based on their Id
     */
	@Override
	public Employee getEmployee(int employeeId) {
		EmployeeEntity employeeEntity = employeeRepo.findById(employeeId).orElse(null);
		Employee employee = new Employee();
		if (!Objects.isNull(employeeEntity)) {
			DepartmentEntity departmentEntity = departmentRepo.findById(employeeEntity.department_id).orElse(null);
			if (!Objects.isNull(departmentEntity)) {
				Department dept = new Department();
				dept.setDepartmentId(departmentEntity.department_id);
				List<Language> languages = new ArrayList<>();
				departmentEntity.languages.stream().forEach(lan -> {
					Language language = new Language();
					language.setCode(lan.code);
					language.setLanguage_id(lan.language_id);
					language.setName(lan.name);
					languages.add(language);
				});
				dept.setLanguages(languages);
				dept.setLocationId(departmentEntity.location_id);
				dept.setStatus(departmentEntity.status);
				employee.setDepartment(dept);
				employee.setEmployeeId(employeeEntity.employee_id);
				employee.setFirstName(employeeEntity.firstName);
				employee.setLastName(employeeEntity.lastName);
			} else {
				throw new GlobalException("No Department Found");
			}
		} else {
			throw new GlobalException("No Employee Found");
		}
		return employee;
	}
    /**
     * This method deletes employee information
     */
	@Override
	public boolean deleteEmployee(int employeeId) {
		boolean check;
		EmployeeEntity employeeEntity = employeeRepo.findById(employeeId).orElse(null);
		if (Objects.isNull(employeeEntity)) {
			check = false;
			throw new GlobalException("No Employee Found");
		} else {
			employeeRepo.delete(employeeEntity);
			check = true;
		}
		return check;
	}
    /**
     * This method will
     * fetch all employees 
     */
	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> employeeList = (List<EmployeeEntity>) employeeRepo.findAll();
		List<Employee> employees = new ArrayList<>();
		employeeList.stream().forEach(emp -> {
			employees.add(getEmployee(emp.employee_id));
		});
		return employees;
	}

}
