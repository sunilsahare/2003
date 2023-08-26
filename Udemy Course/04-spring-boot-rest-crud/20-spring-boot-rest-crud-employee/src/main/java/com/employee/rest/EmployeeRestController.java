package com.employee.rest;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.servce.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // inject employeeDao
    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        return new ResponseEntity<>(employeeService.findById(employeeId), HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<String> getAllEmployee(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);
        return new ResponseEntity<>("Employee Successfully deleted", HttpStatus.OK);
    }

}
