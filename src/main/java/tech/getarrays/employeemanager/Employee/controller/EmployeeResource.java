package tech.getarrays.employeemanager.Employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.Employee.model.EmployeeDTO;
import tech.getarrays.employeemanager.Employee.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/app")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService){ this.employeeService = employeeService;}

    @PostMapping("/employee/save")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.addEmployee(employeeDTO));
    }
    @GetMapping("/employee/get")
    public ResponseEntity<List<EmployeeDTO>> gettAllEmployees() { return ResponseEntity.ok(employeeService.getAllEmployees());}

    @GetMapping("/employee/get/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable String id){
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }
}
