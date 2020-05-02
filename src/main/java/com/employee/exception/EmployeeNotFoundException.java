package com.employee.exception;

public class EmployeeNotFoundException extends RuntimeException {
    ErrorResponse errorResponse;

    public EmployeeNotFoundException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public EmployeeNotFoundException(String message, ErrorResponse errorResponse) {
        super(message);
        this.errorResponse = errorResponse;
    }

    public EmployeeNotFoundException(String message, Throwable cause, ErrorResponse errorResponse) {
        super(message, cause);
        this.errorResponse = errorResponse;
    }

    public EmployeeNotFoundException(Throwable cause, ErrorResponse errorResponse) {
        super(cause);
        this.errorResponse = errorResponse;
    }

    public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorResponse errorResponse) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorResponse = errorResponse;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

}
