package com.employee.controller;

import com.employee.constants.RestConstants;
import com.employee.service.EmployeeService;
import com.employee.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestConstants.API_URI)
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(RestConstants.GET_ALL_EMPLOYEES)
    ResponseEntity getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping(RestConstants.GET_EMPLOYEE_BY_ID)
    ResponseEntity getEmployeeById(@PathVariable("empNo") int empNo){
        return employeeService.getEmployeeById(empNo);
    }

    @PostMapping(RestConstants.SAVE_EMPLOYEE)
    ResponseEntity saveEmployee(@RequestBody EmployeeVO employeeVO){
        return employeeService.saveEmployee(employeeVO);
    }

    @PostMapping(RestConstants.SAVE_ALL_EMPLOYEE)
    ResponseEntity saveAllEmployee(@RequestBody List<EmployeeVO> employeeVO){
        return employeeService.saveAllEmployee(employeeVO);
    }

    @DeleteMapping(RestConstants.DELETE_EMPLOYEE_BY_ID)
    ResponseEntity deleteEmployeeById(@PathVariable("empNo") int empNo){
        return employeeService.deleteEmployeeById(empNo);
    }
}
