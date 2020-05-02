package com.employee.service;

import com.employee.entities.Employee;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.exception.ErrorResponse;
import com.employee.repository.EmployeeRepository;
import com.employee.utils.EmployeeUtils;
import com.employee.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok().body(EmployeeUtils.mapListOfEmployeeToListOfEmployeeVO(employees));
    }

    @Override
    public ResponseEntity getEmployeeById(int empNo) {
       Employee employee = employeeRepository.findById(empNo)
               .orElseThrow(() -> new EmployeeNotFoundException(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Employee Not found for this id :: "+ empNo)));
       return ResponseEntity.ok().body(EmployeeUtils.mapEmployeeToEmployeeVO(employee));
    }

    @Override
    public ResponseEntity saveEmployee(EmployeeVO employeeVO) {

        if(employeeVO == null || employeeVO.getFirstName() == null || employeeVO.getDesignation() == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee is mandatory");
        }
        Employee employee = EmployeeUtils.mapEmployeeVOToEmployee(employeeVO);
        Employee employee1 = employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee1);
    }

    @Override
    public ResponseEntity saveAllEmployee(List<EmployeeVO> employeeVO) {
        if(employeeVO == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee is mandatory");
        }
       List<Employee> employees = EmployeeUtils.mapListOfEmployeeVOToListOfEmployee(employeeVO);
       employeeRepository.saveAll(employees);
        return ResponseEntity.ok().body("All Employees are successfully saved");
    }

    @Override
    public ResponseEntity deleteEmployeeById(int empNo) {
        Optional<Employee> employee = employeeRepository.findById(empNo);
        if(employee.isPresent() == false){
            throw  new EmployeeNotFoundException(new ErrorResponse(HttpStatus.NOT_FOUND, "Employee not found.! "));
        }
        try{
            employeeRepository.delete(employee.get());
            return ResponseEntity.ok().body("Employee is successfully deleted.!");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete at this time. Please try again later.!");
        }
    }
}
