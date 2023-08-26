package com.employee.dao;

import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int employeeId);
    Employee save(Employee employee);
    void deleteById(int employeeId);
}
