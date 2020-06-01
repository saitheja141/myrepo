package com.example.employeemangement.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Department {

	private int departmentId;
	private int locationId;
	private boolean status;
	private LocalDateTime dateAdded;
	private List<Language> languages=new ArrayList<>();
	
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public LocalDateTime getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Department(int departmentId, int locationId, boolean status, LocalDateTime dateAdded,
			List<Language> languages) {
		super();
		this.departmentId = departmentId;
		this.locationId = locationId;
		this.status = status;
		this.dateAdded = dateAdded;
		this.languages = languages;
	}
	public Department() {
		super();
	}
	
}
