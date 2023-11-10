package com.codergm.testcrud.service.impl;

import com.codergm.testcrud.model.Employee;
import com.codergm.testcrud.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if(StringUtils.isAllBlank(employee.getEmployeeId()) || StringUtils.isEmpty(employee.getEmailId())){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employees;
//        return null;
    }
}
