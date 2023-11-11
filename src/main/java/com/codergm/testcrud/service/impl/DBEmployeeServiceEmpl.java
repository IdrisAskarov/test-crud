package com.codergm.testcrud.service.impl;

import com.codergm.testcrud.entity.EmployeeEntity;
import com.codergm.testcrud.model.Employee;
import com.codergm.testcrud.repository.EmployeeRepository;
import com.codergm.testcrud.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        return null;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return null;
    }

    @Override
    public String deleteEmployeeById(String id) {
        return null;
    }
}
