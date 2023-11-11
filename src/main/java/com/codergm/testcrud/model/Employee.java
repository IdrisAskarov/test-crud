package com.codergm.testcrud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties()
public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String department;
}
