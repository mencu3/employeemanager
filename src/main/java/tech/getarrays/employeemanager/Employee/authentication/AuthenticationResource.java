package tech.getarrays.employeemanager.Employee.authentication;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.getarrays.employeemanager.Employee.model.Employee;
import tech.getarrays.employeemanager.Employee.model.EmployeeDTO;
import tech.getarrays.employeemanager.Employee.model.EmployeeMapper;
import tech.getarrays.employeemanager.Employee.service.EmployeeService;

@RestController
@AllArgsConstructor
@RequestMapping("/app")
@Slf4j
public class AuthenticationResource {

    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;

    @GetMapping(path = "/login")
    public ResponseEntity<EmployeeDTO> login(){
        Employee employee = employeeService.findByEmployeename(
                SecurityContextHolder.getContext().getAuthentication().getName());

        log.info(String.valueOf(employee));

        return ResponseEntity.ok(EmployeeMapper.toDTO(employee));

    }
}
