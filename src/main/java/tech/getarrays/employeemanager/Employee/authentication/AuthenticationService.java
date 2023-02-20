package tech.getarrays.employeemanager.Employee.authentication;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import tech.getarrays.employeemanager.Employee.model.Employee;
import tech.getarrays.employeemanager.Employee.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AuthenticationService implements AuthenticationProvider {

    private final EmployeeRepository employeeRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String employeename = authentication.getName();
        String password = authentication.getCredentials().toString();

        Employee employee = employeeRepository.findByEmployeenameAndPassword(employeename,password);

        if (employee != null){
            List<GrantedAuthority> authorities = new ArrayList<>();

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(employeename,password,authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return token;
        }
        if (employee == null){
            throw new AuthenticationException("User not found") {
            };
        }
        return null;
    }
    public GrantedAuthority createAuthority(String role){
        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            @Override
            public String getAuthority() { return role;}
        };
        return grantedAuthority;
    }

    @Override
    public boolean supports(Class<?> authentication){
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
