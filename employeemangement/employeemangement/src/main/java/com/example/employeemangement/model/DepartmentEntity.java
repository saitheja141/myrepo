package com.example.employeemangement.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class DepartmentEntity {
	
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int department_id;
	public int location_id;
	public boolean status;
	public LocalDateTime date_added;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "department_languages", joinColumns = {@JoinColumn(name = "department_id") }, 
       inverseJoinColumns = { @JoinColumn(name = "language_id") })
	public List<LanguageEntity> languages=new ArrayList<>();
	
}
