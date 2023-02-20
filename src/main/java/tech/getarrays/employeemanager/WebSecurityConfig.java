package tech.getarrays.employeemanager;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import tech.getarrays.employeemanager.Employee.authentication.AuthenticationService;

@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationService authenticationService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                // name and psw don't need any authentication
                .antMatchers(HttpMethod.OPTIONS,"/app/**").permitAll()
                // other requests need authentication
                .antMatchers("/app/medias/**").permitAll()
                .antMatchers("/app/**").authenticated()

                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationService);
    }
}
