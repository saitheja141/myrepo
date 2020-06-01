package com.example.employeemangement.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemangement.GlobalException;
import com.example.employeemangement.model.Department;
import com.example.employeemangement.model.DepartmentEntity;
import com.example.employeemangement.model.Language;
import com.example.employeemangement.model.LanguageEntity;
import com.example.employeemangement.repository.IDepartmentsRepo;
import com.example.employeemangement.repository.ILanguagesRepo;
/**
 * This class mainly deals
 * with service operation 
 * related to Department resource
 * @author saitheja macharla
 *
 */
@Service
@Transactional
public class DepartmentService implements IDepartmentsService {

	@Autowired
	IDepartmentsRepo departmentRepo;

	@Autowired
	ILanguagesRepo languageRepo;
    /**
     * This method creates a new Department
     */
	@Override
	public Department saveDepartment(Department department) {
		try {
		DepartmentEntity departmentEntity = new DepartmentEntity();
		departmentEntity.status = true;
		departmentEntity.location_id = department.getLocationId();
		departmentEntity.date_added = LocalDateTime.now();
		List<LanguageEntity> languagesList = new ArrayList<>();
		List<Language> languages = new ArrayList<>();
		department.getLanguages().stream().forEach(lId -> {
			Language language=new Language();
			LanguageEntity languageEntity = languageRepo.findById(lId.getLanguage_id()).orElse(null);
		    language.setCode(languageEntity.code);
		    language.setName(languageEntity.name);
		    language.setLanguage_id(languageEntity.language_id);
		    languages.add(language);
			languagesList.add(languageEntity);
		});
		departmentEntity.languages = languagesList;
		departmentEntity = departmentRepo.save(departmentEntity);
		department.setLanguages(languages);
		department.setDateAdded(departmentEntity.date_added);
		department.setDepartmentId(departmentEntity.department_id);
		return department;
		}
		catch(Exception e)
		{
			throw new GlobalException("No Language found");
		}
	}
    /**
     * This method updates department information
     */
	@Override
	public Department updateDepartment(int departmentId,Department department) {
		DepartmentEntity departmentEntity=departmentRepo.findById(departmentId).orElse(null);
		if(Objects.isNull(departmentEntity))
		{
			throw new GlobalException("No Department found");
		}
		else
		{
			try
			{
				departmentEntity.location_id=department.getLocationId();
				departmentEntity.date_added=department.getDateAdded();
				departmentEntity.status=department.isStatus();
				/*departmentRepo.delete(departmentEntity);*/
				departmentEntity=departmentRepo.save(departmentEntity);
				department.setDateAdded(departmentEntity.date_added);
				department.setDepartmentId(departmentEntity.department_id);
				department.setStatus(departmentEntity.status);
			}	
			catch(Exception e)
			{
				throw new GlobalException("Problem with service .Please try after some time");
			}
			return department;
		}
	}
    /**
     * This method deletes  a department 
     */
	@Override
	public boolean deleteDepartment(int departmentId) {
		boolean check;
		DepartmentEntity departmentEntity=departmentRepo.findById(departmentId).orElse(null);
		if(Objects.isNull(departmentEntity))
		{
			check=false;
			throw new GlobalException("No Department found");
		}
		else
		{
			departmentRepo.delete(departmentEntity);
			check=true;
		}
		return check;
	}
    /**
     * This method fetches  a department based on departmentId
     */
	@Override
	public Department getDepartment(int departmentId) {
		DepartmentEntity departmentEntity=departmentRepo.findById(departmentId).orElse(null);
		Department department=new Department();
		if(!Objects.isNull(departmentEntity))
		{
			department.setDateAdded(departmentEntity.date_added);
			department.setDepartmentId(departmentEntity.department_id);
			department.setStatus(departmentEntity.status);
			List<Language> languages = new ArrayList<>();
			departmentEntity.languages.forEach(lan->{
				Language language=new Language();
				language.setCode(lan.code);
				language.setLanguage_id(lan.language_id);
				language.setName(lan.name);
				languages.add(language);
			});
			department.setLanguages(languages);
		}
		else
		{
		  throw new GlobalException("No Department found");
		}
		
		return department;
	}
	


}
