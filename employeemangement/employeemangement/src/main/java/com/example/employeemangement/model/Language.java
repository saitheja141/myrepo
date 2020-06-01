package com.example.employeemangement.model;

public class Language {

	private int language_id;
	private String name;
	private String code;

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Language(int language_id, String name, String code) {
		super();
		this.language_id = language_id;
		this.name = name;
		this.code = code;
	}

	public Language() {
		super();
	}
     
}
