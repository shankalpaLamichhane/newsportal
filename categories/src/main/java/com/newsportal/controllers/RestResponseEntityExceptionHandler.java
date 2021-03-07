package com.newsportal.controllers;

import com.newsportal.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author sankalpa on 3/7/21
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
   @ExceptionHandler({ResourceNotFoundException.class})
   public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest request){
       return new ResponseEntity<Object>("Resource not found",new HttpHeaders(), HttpStatus.NOT_FOUND);
   }
}
