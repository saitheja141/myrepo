package com.example.employeemangement;
/**
 * Custom Exception class 
 * @author saitheja macharla
 *
 */
public class GlobalException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public GlobalException(String message)
	{
		super(message);
	}

}
