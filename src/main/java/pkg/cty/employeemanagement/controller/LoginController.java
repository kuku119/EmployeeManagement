package pkg.cty.employeemanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pkg.cty.employeemanagement.pojo.User;
import pkg.cty.employeemanagement.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static pkg.cty.employeemanagement.constant.CommonConstant.LOGIN_MESSAGE;
import static pkg.cty.employeemanagement.constant.CommonConstant.LOGIN_USER;


@Slf4j
@Controller
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("/user/login")
    public String login(@Param("username") String username, @Param("password") String password, Model model, HttpSession session) {
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            // 如果密码为空
            log.info("尝试使用空用户名或空密码登录");
            model.addAttribute(LOGIN_MESSAGE, "用户名或密码为空");
            return "index";
        }

        User user = userService.getUser(username);
        if (user != null && password.equals(user.getPassword())) {
            // 如果账号和密码正确，就允许登录，进入 main 页面
            log.info(String.format("登录成功，账号：%s", user.getUsername()));
            session.setAttribute(LOGIN_USER, user.getUsername());
            // return "redirect:/main?loginUser=" + user.getUsername();
            return "main";
        } else {
            // 如果账号或密码错误，就禁止登录，并提示密码错误
            log.info(String.format("登录失败，尝试使用账号 '%s' 和密码 '%s' 登录，账号或密码错误", username, password));
            model.addAttribute(LOGIN_MESSAGE, "用户名或密码错误");
            return "index";
        }
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        // 注销
        log.info(String.format("用户 %s 注销", session.getAttribute(LOGIN_USER)));
        session.setAttribute(LOGIN_MESSAGE, "用户已注销");
        session.invalidate();
        return "redirect:/index";
    }
}
