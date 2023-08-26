package com.employee.service;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId) throws EmployeeNotFoundException;

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
