package com.codergm.testcrud.service.impl;

import com.codergm.testcrud.entity.EmployeeEntity;
import com.codergm.testcrud.exception.EmployeeNotFoundException;
import com.codergm.testcrud.model.Employee;
import com.codergm.testcrud.repository.EmployeeRepository;
import com.codergm.testcrud.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("dbEmployeeService")
public class DBEmployeeServiceEmpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public DBEmployeeServiceEmpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee save(Employee employee) {
        if (StringUtils.isAllBlank(employee.getEmployeeId()) || StringUtils.isEmpty(employee.getEmailId())) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = employeeEntities.stream().map(empl -> {
            Employee employee = new Employee();
            BeanUtils.copyProperties(empl, employee);
            return employee;
        }).collect(Collectors.toList());
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
        employeeRepository.delete(employeeEntity);
        return "Employee deleted with the id: " + id;
    }
}
