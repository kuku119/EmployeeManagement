package pkg.cty.employeemanagement.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkg.cty.employeemanagement.dao.DepartmentMapper;
import pkg.cty.employeemanagement.pojo.Department;


import java.util.List;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentServiceTest {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void getDepartment() {
        System.out.println(departmentMapper.getDepartment(1));
    }

    @Test
    public void listDepartments() {
        List<Department> results = departmentMapper.listDepartments();
        results.forEach(System.out::println);
    }
}