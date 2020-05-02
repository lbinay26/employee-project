package com.employee.utils;

import com.employee.entities.Employee;
import com.employee.vo.EmployeeVO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeUtils {

    public static List<EmployeeVO> mapListOfEmployeeToListOfEmployeeVO(List<Employee> employees){
        return employees.stream().map(employee -> {
            EmployeeVO employeeVO = new EmployeeVO();
            employeeVO.setEmpNo(employee.getEmpNo());
            employeeVO.setDesignation(employee.getDesignation());
            employeeVO.setFirstName(employee.getFirstName());
            employeeVO.setLastName(employee.getLastName());
            employeeVO.setSalary(employee.getSalary());
            return employeeVO;
        }).collect(Collectors.toList());

    }

    public static EmployeeVO mapEmployeeToEmployeeVO(Employee employee){
            EmployeeVO employeeVO = new EmployeeVO();
            employeeVO.setEmpNo(employee.getEmpNo());
            employeeVO.setDesignation(employee.getDesignation());
            employeeVO.setFirstName(employee.getFirstName());
            employeeVO.setLastName(employee.getLastName());
            employeeVO.setSalary(employee.getSalary());
            return employeeVO;
    }

    public static Employee mapEmployeeVOToEmployee(EmployeeVO employeeVO){
        Employee employee = new Employee();
        employee.setEmpNo(employeeVO.getEmpNo());
        employee.setFirstName(employeeVO.getFirstName());
        employee.setLastName(employeeVO.getLastName());
        employee.setDesignation(employeeVO.getDesignation());
        employee.setSalary(employeeVO.getSalary());
        return employee;
    }

    public static List<Employee> mapListOfEmployeeVOToListOfEmployee(List<EmployeeVO> employeeVOS){
        return employeeVOS.stream()
                .map(employeeVO -> {
                    Employee employee = new Employee();
                    employee.setEmpNo(employeeVO.getEmpNo());
                    employee.setFirstName(employeeVO.getFirstName());
                    employee.setLastName(employeeVO.getLastName());
                    employee.setDesignation(employeeVO.getDesignation());
                    employee.setSalary(employeeVO.getSalary());
                    return  employee;
                }).collect(Collectors.toList());
    }
}
