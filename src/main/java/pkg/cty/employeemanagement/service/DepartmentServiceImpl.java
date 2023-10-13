package pkg.cty.employeemanagement.service;

import org.springframework.stereotype.Service;
import pkg.cty.employeemanagement.dao.DepartmentMapper;
import pkg.cty.employeemanagement.pojo.Department;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepartment(int departmentId) {
        return departmentMapper.getDepartment(departmentId);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentMapper.getDepartmentByName(name);
    }

    @Override
    public List<Department> listDepartments() {
        return departmentMapper.listDepartments();
    }
}
