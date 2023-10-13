package pkg.cty.employeemanagement.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pkg.cty.employeemanagement.constant.CommonConstant;
import pkg.cty.employeemanagement.dao.EmployeeMapper;
import pkg.cty.employeemanagement.pojo.Employee;

import javax.annotation.Resource;
import java.util.List;

// @Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    EmployeeMapper employeeMapper;

    @Override
    public Integer insertEmployee(Employee employee) {
        // log.info(String.format("调用 insertEmployee(%s)", employee));
        employee.setCreateTime(CommonConstant.CURRENT_TIME);
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public Integer updateEmployee(Employee employee) {
        // log.info(String.format("调用 updateEmployee(%s)", employee));
        employee.setUpdateTime(CommonConstant.CURRENT_TIME);
        return employeeMapper.updateEmployee(employee);
    }


    @Override
    public Integer deleteEmployee(Integer employeeId) {
        // log.info(String.format("调用 deleteEmployee(%d)", employeeId));
        return employeeMapper.deleteEmployee(employeeId);
    }

    @Override
    public Employee getEmployee(Integer employeeId) {
        // log.info(String.format("调用 getEmployee(%d)", employeeId));
        return employeeMapper.getEmployee(employeeId);
    }

    @Override
    public List<Employee> listEmployees() {
        // log.info("调用 listEmployees()");
        return employeeMapper.listEmployees();
    }
}
