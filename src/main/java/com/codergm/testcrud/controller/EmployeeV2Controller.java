package com.codergm.testcrud.controller;

import com.codergm.testcrud.model.Employee;
import com.codergm.testcrud.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/employee")
public class EmployeeV2Controller {

    private final EmployeeService employeeService;

    public EmployeeV2Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("{id}")
    public String deleteEmployeeById(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }
}
