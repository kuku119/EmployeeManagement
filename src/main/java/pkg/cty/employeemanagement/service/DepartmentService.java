package pkg.cty.employeemanagement.service;

import pkg.cty.employeemanagement.pojo.Department;

import java.util.List;

public interface DepartmentService {
    Department getDepartment(int departmentId);

    Department getDepartmentByName(String name);

    List<Department> listDepartments();
}
