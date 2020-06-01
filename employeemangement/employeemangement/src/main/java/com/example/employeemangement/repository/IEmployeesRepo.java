package com.example.employeemangement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemangement.model.EmployeeEntity;

/**
 * This class as Repo layer for Employees Resource
 * @author saitheja macharla
 *
 */
@Repository
public interface IEmployeesRepo extends CrudRepository<EmployeeEntity, Integer> {

}
