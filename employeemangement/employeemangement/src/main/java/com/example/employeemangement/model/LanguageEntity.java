package com.example.employeemangement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="languages")
public class LanguageEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int language_id;
	public String name;
	public String code;

}
