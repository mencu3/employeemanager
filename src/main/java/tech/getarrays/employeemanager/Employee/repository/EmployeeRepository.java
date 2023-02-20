package tech.getarrays.employeemanager.Employee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.getarrays.employeemanager.Employee.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByEmployeename(String employeename);
    Employee findByEmployeenameAndPassword(String employeename, String password); /* belki parantez içindeki değişecek*/
}
