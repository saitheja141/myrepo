package com.example.employeemangement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemangement.model.DepartmentEntity;
/**
 * This class as Repo layer for Departments Resource
 * @author saitheja macharla
 *
 */
@Repository
public interface IDepartmentsRepo extends CrudRepository<DepartmentEntity, Integer> {

}
