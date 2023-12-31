package pkg.cty.employeemanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pkg.cty.employeemanagement.constant.CommonConstant;
import pkg.cty.employeemanagement.pojo.Department;
import pkg.cty.employeemanagement.pojo.Employee;
import pkg.cty.employeemanagement.service.DepartmentService;
import pkg.cty.employeemanagement.service.EmployeeService;
import pkg.cty.employeemanagement.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static pkg.cty.employeemanagement.constant.CommonConstant.*;

@Slf4j
@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private UserService userService;


    @GetMapping("/employee/listEmployees")
    public String listEmployees(Model model, HttpSession session) {
        String loginUser = (String) session.getAttribute(LOGIN_USER);
        log.info(String.format("用户 %s 调用 /employee/listEmployees", loginUser));
        if (loginUser != null && (userService.getUser(loginUser).getPermission() & 1) != 0) {
            // 判断用户是否有查询权限
            List<Employee> employeeList = employeeService.listEmployees();
            model.addAttribute("employeeList", employeeList);
        } else {
            model.addAttribute(SELECT_MESSAGE, "无查询权限");
        }
        return "main";
    }

    @PostMapping("employee/insertEmployee")
    public String insertEmployee(@RequestParam(value = "insertEmployeeId") Integer insertEmployeeId, @RequestParam(value = "insertEmployeeName") String insertEmployeeName, @RequestParam(value = "insertEmployeeEmail", required = false) String insertEmployeeEmail, @RequestParam(value = "insertEmployeeGender", required = false) Integer insertEmployeeGender, @RequestParam(value = "insertEmployeeBirthday", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date insertEmployeeBirthday, @RequestParam(value = "insertEmployeeDepartmentName") String insertEmployeeDepartmentName, Model model, HttpSession session) {
        String loginUser = (String) session.getAttribute(LOGIN_USER);
        log.info(String.format("账号 %s 调用 /employee/insertEmployee", session.getAttribute(LOGIN_USER)));
        if (loginUser != null && (userService.getUser(loginUser).getPermission() & 2) != 0) {
            // 判断用户是否有插入权限
            if (employeeService.getEmployee(insertEmployeeId) != null) {
                // 如果员工编号已存在，就不再添加，并在网页上提示用户编号已存在
                model.addAttribute(CommonConstant.INSERT_MESSAGE, "员工已存在");
                return listEmployees(model, session);
            }

            Department department = departmentService.getDepartmentByName(insertEmployeeDepartmentName);
            if (department == null) {
                // 如果部门不存在，就禁止添加，并在网页上提示部门不存在
                model.addAttribute(INSERT_MESSAGE, "部门不存在");
                return listEmployees(model, session);
            }

            if (insertEmployeeGender == -1) {
                insertEmployeeGender = null;
            }

            Employee employee = new Employee(insertEmployeeId, insertEmployeeName, insertEmployeeEmail, insertEmployeeGender, insertEmployeeBirthday, department);
            employeeService.insertEmployee(employee);
        } else {
            model.addAttribute(INSERT_MESSAGE, "无插入权限");
        }
        return listEmployees(model, session);
    }

    @PostMapping("/employee/updateEmployee")
    public String updateEmployee(@RequestParam(value = "updateEmployeeId") Integer updateEmployeeId, @RequestParam(value = "updateEmployeeName") String updateEmployeeName, @RequestParam(value = "updateEmployeeEmail", required = false) String updateEmployeeEmail, @RequestParam(value = "updateEmployeeGender", required = false) Integer updateEmployeeGender, @RequestParam(value = "updateEmployeeBirthday", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date updateEmployeeBirthday, @RequestParam(value = "updateEmployeeDepartmentName") String updateEmployeeDepartmentName, Model model, HttpSession session) {
        String loginUser = (String) session.getAttribute(LOGIN_USER);
        log.info(String.format("账号 %s 调用 /employee/updateEmployee", session.getAttribute(LOGIN_USER)));
        if (loginUser != null && (userService.getUser(loginUser).getPermission() & 4) != 0) {
            // 判断用户是否有更新权限
            if (employeeService.getEmployee(updateEmployeeId) == null) {
                // 如果员工编号不存在
                model.addAttribute(UPDATE_MESSAGE, "员工不存在");
                return listEmployees(model, session);
            }

            Department department = departmentService.getDepartmentByName(updateEmployeeDepartmentName);
            if (department == null) {
                model.addAttribute(UPDATE_MESSAGE, "部门不存在");
                return listEmployees(model, session);
            }

            if (updateEmployeeGender == -1) {
                updateEmployeeGender = null;
            }

            Employee employee = new Employee(updateEmployeeId, updateEmployeeName, updateEmployeeEmail, updateEmployeeGender, updateEmployeeBirthday, department);
            employeeService.updateEmployee(employee);
        } else {
            model.addAttribute(UPDATE_MESSAGE, "无更新权限");
        }
        return listEmployees(model, session);
    }

    @PostMapping("employee/deleteEmployee")
    public String deleteEmployee(@RequestParam(value = "deleteEmployeeId") Integer deleteEmployeeId, Model model, HttpSession session) {
        String loginUser = (String) session.getAttribute(LOGIN_USER);
        log.info(String.format("账号 %s 调用 /employee/deleteEmployee", loginUser));
        if (loginUser != null && (userService.getUser(loginUser).getPermission() & 8) != 0) {
            // 判断用户是否有删除权限
            Employee employee = employeeService.getEmployee(deleteEmployeeId);
            if (employee == null) {
                // 如果员工不存在
                model.addAttribute(DELETE_MESSAGE, "员工不存在");
                return listEmployees(model, session);
            }
            employeeService.deleteEmployee(deleteEmployeeId);
        } else {
            model.addAttribute(DELETE_MESSAGE, "无删除权限");
        }
        return listEmployees(model, session);
    }

}
