package com.example.employeemangement.service;

import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemangement.GlobalException;
import com.example.employeemangement.model.Language;
import com.example.employeemangement.model.LanguageEntity;
import com.example.employeemangement.repository.ILanguagesRepo;
/**
 * This class mainly deals
 * with service operations 
 * related to Languages
 * @author saitheja macharla
 *
 */
@Service
@Transactional
public class LanguagesService implements ILanguagesService {

	@Autowired
	ILanguagesRepo ilanguageRepo;
	/**
	 * This method crates a new  language 
	 */
	@Override
	public Language saveLanguage(Language language) {
		LanguageEntity languageEntity=new LanguageEntity();
		try
		{
			languageEntity.code=language.getCode();
			languageEntity.language_id=language.getLanguage_id();
			languageEntity.name=language.getName();
			languageEntity=ilanguageRepo.save(languageEntity);
			language.setLanguage_id(languageEntity.language_id);
			language.setCode(languageEntity.code);
			language.setName(languageEntity.name);
		}	
		catch(Exception e)
		{
			throw new GlobalException("Problem with service .Please try after some time");
		}
		return language;
	}
    /**
     * This method updates  language information
     */
	@Override
	public Language updateLanguage(int languageId,Language language) {
		LanguageEntity languageEntity=ilanguageRepo.findById(languageId).orElse(null);
		if(Objects.isNull(languageEntity))
		{
			throw new GlobalException("No Language Found");
		}
		else
		{
			try
			{
				languageEntity.code=language.getCode();
				languageEntity.name=language.getName();
				languageEntity=ilanguageRepo.save(languageEntity);
				language.setLanguage_id(languageEntity.language_id);
				language.setCode(languageEntity.code);
				language.setName(languageEntity.name);
			}	
			catch(Exception e)
			{
				throw new GlobalException("Problem with service .Please try after some time");
			}
		}
		
		return  language;
	}
    /**
     * This method deletes
     * a language  
     */
	@Override
	public boolean deleteLanguage(int languageId) {
		boolean check;
		LanguageEntity languageEntity=ilanguageRepo.findById(languageId).orElse(null);
		if(Objects.isNull(languageEntity))
		{
			check=false;
			throw new GlobalException("No Language Found");
		}
		else
		{
			ilanguageRepo.delete(languageEntity);
			check=true;
		}
		return check;
	}
	
	/**
	 * This method gets a specific language 
	 * by languageId
	 */
	@Override
	public Language getLanguageById(int languageId) {
	LanguageEntity languageEntity=ilanguageRepo.findById(languageId).orElse(null);
	Language language=new Language();
	if(!Objects.isNull(languageEntity))
	{
		language.setLanguage_id(languageEntity.language_id);
		language.setCode(languageEntity.code);
		language.setName(languageEntity.name);
	}
	else
	{
		throw new GlobalException("No Language Found");
	}
     return language;
	}
}
