package tech.getarrays.employeemanager.Employee.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class EmployeeMapper implements Serializable {

    public static EmployeeDTO toDTO(Employee employee){
        if ( employee == null){
            return null;
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(employee.getId());
        employeeDTO.setEmployeename(employee.getEmployeename());
        employeeDTO.setPassword(employee.getPassword());
        employeeDTO.setFullName(employee.getFullName());

        return employeeDTO;
    }
    public static Employee toEntity(EmployeeDTO employeeDTO){
        if (employeeDTO == null){
            return null;
        }
        Employee employee = new Employee();

        employee.setId(employee.getId());
        employee.setEmployeename(employee.getEmployeename());
        employee.setPassword(employee.getPassword());
        employee.setFullName(employee.getFullName());

        return employee;
    }
}
