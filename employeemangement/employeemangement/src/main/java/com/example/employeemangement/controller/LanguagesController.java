package com.example.employeemangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemangement.GlobalException;
import com.example.employeemangement.model.Language;
import com.example.employeemangement.service.ILanguagesService;
/**
 * This Rest controller mainly 
 * performs CRUD Operations 
 * on languages resource 
 * @author saitheja macharla
 */
@RestController
public class LanguagesController {

	@Autowired
	ILanguagesService languageService;
    /**
     * This method will fetch language based on languageId
     * and can be accessed by users with role admin only 
     * @param languageId
     * @return
     */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/languages/{languageId}", method = RequestMethod.GET)
	public ResponseEntity<Language> getLanguage(@PathVariable int languageId) {
		try {
			return new ResponseEntity<Language>(languageService.getLanguageById(languageId), HttpStatus.OK);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}
	}
    /**
     * This method will create a new language
     * and can be accessed by users with role admin only 
     * @param language
     * @return
     */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/languages", method = RequestMethod.POST)
	public ResponseEntity<Language> saveLanguage(@RequestBody Language language) {
		try {
			return new ResponseEntity<Language>(languageService.saveLanguage(language), HttpStatus.CREATED);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}
	}
    /**
     * This method will update language information 
     * and can be accessed by users with role admin only 
     * @param languageId
     * @param language
     * @return
     */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/languages/{languageId}", method = RequestMethod.PUT)
	public ResponseEntity<Language> updateLanguage(@PathVariable int languageId, @RequestBody Language language) {
		try {
			return new ResponseEntity<Language>(languageService.updateLanguage(languageId, language), HttpStatus.OK);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}
	}
    /**
     * This method will delete language  
     * and can be accessed by users with role admin only 
     * @param languageId
     * @return
     */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/languages/{languageId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteLanguage(@PathVariable int languageId) {
		try {
			return new ResponseEntity<Boolean>(languageService.deleteLanguage(languageId), HttpStatus.OK);
		} catch (GlobalException ge) {
			throw new GlobalException(ge.getMessage());
		}
	}

}
