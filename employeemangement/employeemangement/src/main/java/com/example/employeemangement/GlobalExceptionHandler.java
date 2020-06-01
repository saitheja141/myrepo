package com.example.employeemangement;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * This class acts a
 * global exception handler for entire 
 * application .
 * @author saitheja macharla
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

  @ExceptionHandler(value= {Exception.class})
  public ResponseEntity<GlobalExceptionResponse> handleException(GlobalException globalException)
  {
	  GlobalExceptionResponse globalExceptionResponse=new GlobalExceptionResponse();
	  globalExceptionResponse.setMessage(globalException.getMessage());
	  globalExceptionResponse.setLocalDateTime(LocalDateTime.now());
	  globalExceptionResponse.setHttpStatus(HttpStatus.OK);
	  globalExceptionResponse.setStatus(false);
	  return new ResponseEntity<GlobalExceptionResponse>(globalExceptionResponse,HttpStatus.OK);
  }
	
}
