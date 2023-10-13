package pkg.cty.employeemanagement.service;

import pkg.cty.employeemanagement.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    Integer insertEmployee(Employee employee);

    Integer deleteEmployee(Integer employeeId);

    Integer updateEmployee(Employee employee);

    Employee getEmployee(Integer employeeId);

    List<Employee> listEmployees();
}
