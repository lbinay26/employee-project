package com.employee.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionControllerAdvice  {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public  final ResponseEntity<ErrorResponse> employeeNotFound(EmployeeNotFoundException e){
        return new ResponseEntity<ErrorResponse>(e.getErrorResponse(), e.getErrorResponse().getStatusCode());
    }
}
