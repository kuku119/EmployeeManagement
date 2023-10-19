package pkg.cty.employeemanagement.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkg.cty.employeemanagement.constant.CommonConstant;
import pkg.cty.employeemanagement.dao.DepartmentMapper;
import pkg.cty.employeemanagement.dao.EmployeeMapper;
import pkg.cty.employeemanagement.pojo.Employee;

import java.util.List;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void insertEmployee() {
        System.out.println(employeeMapper.insertEmployee(
                new Employee(CommonConstant.CURRENT_TIME,
                        CommonConstant.CURRENT_TIME,
                        9999,
                        "test_insert",
                        "test@test.com",
                        0,
                        CommonConstant.CURRENT_TIME,
                        departmentMapper.getDepartment(1))));
    }

    @Test
    public void deleteEmployee() {
        System.out.println(employeeMapper.deleteEmployee(9999));
    }

    @Test
    public void updateEmployee() {
        System.out.println(employeeMapper.updateEmployee(
                new Employee(CommonConstant.CURRENT_TIME,
                        CommonConstant.CURRENT_TIME,
                        9999,
                        "test_update",
                        "test@test.com",
                        0,
                        CommonConstant.CURRENT_TIME,
                        departmentMapper.getDepartment(1))));
    }

    @Test
    public void getEmployee() {
        System.out.println(employeeMapper.getEmployee(9999));
    }


    @Test
    public void listEmployees() {
        List<Employee> results = employeeMapper.listEmployees();
        results.forEach(System.out::println);
    }
}