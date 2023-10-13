package pkg.cty.employeemanagement.dao;

import org.apache.ibatis.annotations.Mapper;
import pkg.cty.employeemanagement.pojo.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    Integer insertEmployee(Employee employee);

    Integer deleteEmployee(int employeeId);

    Integer updateEmployee(Employee employee);

    Employee getEmployee(int employeeId);


    List<Employee> listEmployees();
}
