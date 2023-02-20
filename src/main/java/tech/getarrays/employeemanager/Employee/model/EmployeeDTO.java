package tech.getarrays.employeemanager.Employee.model;

import lombok.*;

import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {
    private String id;
    private String employeename;
    private String password;
    private String fullName;
}
