package tech.getarrays.employeemanager.Employee.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.Employee.model.Employee;
import tech.getarrays.employeemanager.Employee.model.EmployeeDTO;
import tech.getarrays.employeemanager.Employee.model.EmployeeMapper;
import tech.getarrays.employeemanager.Employee.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO){
        Employee employee = employeeRepository.save(EmployeeMapper.toEntity(employeeDTO));
        log.info(String.valueOf(employee));
        return EmployeeMapper.toDTO(employee);
    }
    public EmployeeDTO findEmployeeById(String id){
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()){
            Employee employee = optional.get();
            return EmployeeMapper.toDTO(employee);
        }
        return null;
    }
    public Boolean deleteUserById(String id){
        employeeRepository.deleteById(id);
        if (findEmployeeById(id) == null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();

        for (Employee employee: employees){
            employeeDTOS.add(EmployeeMapper.toDTO(employee));
        }
        return employeeDTOS;
    }
    public Employee findByEmployeename(String name) {
        Employee employee = employeeRepository.findByEmployeename(name);
        return employee == null ? null : employee;
    }
}