package com.employee.service;

import com.employee.vo.EmployeeVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    ResponseEntity getAllEmployee();

    ResponseEntity getEmployeeById(int empNo);

    ResponseEntity saveEmployee(EmployeeVO employeeVO);

    ResponseEntity saveAllEmployee(List<EmployeeVO> employeeVO);

    ResponseEntity deleteEmployeeById(int empNo);
}
