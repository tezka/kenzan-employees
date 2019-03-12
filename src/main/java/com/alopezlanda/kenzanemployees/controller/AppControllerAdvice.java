package com.alopezlanda.kenzanemployees.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alopezlanda.kenzanemployees.dto.AppException;
import com.alopezlanda.kenzanemployees.exception.ResourceNotFoundException;
import com.alopezlanda.kenzanemployees.exception.UnauthorizedException;

@ControllerAdvice
public class AppControllerAdvice {
  @ExceptionHandler(ResourceNotFoundException.class) 
  public ResponseEntity<AppException> exception(ResourceNotFoundException ex){
    return generateException(HttpStatus.NOT_FOUND, ex.getMessage());
  }
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<AppException> exception(Exception ex) {
    return generateException(HttpStatus.INTERNAL_SERVER_ERROR, "Contact the developer team");
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<AppException> exception(MethodArgumentNotValidException ex) {
    return generateException(HttpStatus.BAD_REQUEST, "The payload contains errors");
  }

  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<AppException> exception(UnauthorizedException ex) {
    return generateException(HttpStatus.UNAUTHORIZED, ex.getMessage());
  }
  
  
  private ResponseEntity<AppException> generateException(HttpStatus status, String message){
    AppException ex = new AppException();
    ex.setMessage(message);
    ex.setStatus(status.value());
    return new ResponseEntity<AppException>(ex, status);
    
  }
}
