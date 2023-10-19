package pkg.cty.employeemanagement.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

import static pkg.cty.employeemanagement.constant.CommonConstant.LOGIN_MESSAGE;
import static pkg.cty.employeemanagement.constant.CommonConstant.LOGIN_USER;


@Slf4j
public class WebInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginUser = (String) request.getSession().getAttribute(LOGIN_USER);
        Integer requestId = new Random().nextInt(100000);
        log.info(String.format("[%05d] 拦截到一个来自账号 %s 的请求...", requestId, loginUser));
        if (!StringUtils.hasLength(loginUser)) {
            request.setAttribute(LOGIN_MESSAGE, "没有访问权限，请先登录！");
            request.getRequestDispatcher("/index").forward(request, response);
            log.info(String.format("[%05d] 请求已拦截", requestId));
            return false;
        } else {
            log.info(String.format("[%05d] 请求已放行", requestId));
            return true;
        }
    }
}
