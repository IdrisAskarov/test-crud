package com.codergm.testcrud.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String department;
}
