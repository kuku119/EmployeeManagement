package pkg.cty.employeemanagement.dao;

import org.apache.ibatis.annotations.Mapper;
import pkg.cty.employeemanagement.pojo.Department;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    Department getDepartment(int departmentId);

    Department getDepartmentByName(String name);

    List<Department> listDepartments();
}
