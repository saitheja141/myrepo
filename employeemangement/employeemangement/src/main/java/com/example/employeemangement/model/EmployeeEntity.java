package com.example.employeemangement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public  int employee_id;
	public  int department_id;
	public String firstName;
	public String lastName;
}
