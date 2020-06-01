package com.example.employeemangement.service;

import com.example.employeemangement.model.Language;
/**
 * This interface has been implemented by LanguagesService
 * @author saitheja macharla
 *
 */
public interface ILanguagesService {
	
	public Language saveLanguage(Language language);
	public Language updateLanguage(int languageId,Language language);
    public boolean deleteLanguage(int languageId);
    public Language getLanguageById(int languageId);
}
