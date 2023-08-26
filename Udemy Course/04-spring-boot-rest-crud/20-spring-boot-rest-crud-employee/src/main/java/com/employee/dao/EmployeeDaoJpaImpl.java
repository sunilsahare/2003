package com.employee.dao;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao{

    // define field for entityManager
    private EntityManager entityManager;

    //set up constructor injection
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result
        List<Employee> employeeList = query.getResultList();

        //return result
        return employeeList;
    }

    @Override
    public Employee findById(int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);

        if (employee == null) {
            throw new EmployeeException("Employee not found - "+employeeId);
        }

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee savedEmployee = entityManager.merge(employee);
        return savedEmployee;
    }

    @Override
    public void deleteById(int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);

        if (employee == null) {
            throw new EmployeeException("Employee not found - "+employeeId);
        }

        entityManager.remove(employee);
    }

}
