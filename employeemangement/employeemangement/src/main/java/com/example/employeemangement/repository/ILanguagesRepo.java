package com.example.employeemangement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemangement.model.LanguageEntity;

/**
 * This class as Repo layer for Languages Resource
 * @author saitheja macharla
 *
 */
@Repository
public interface ILanguagesRepo extends CrudRepository<LanguageEntity, Integer> {
	
	

}
