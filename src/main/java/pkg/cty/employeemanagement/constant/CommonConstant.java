package pkg.cty.employeemanagement.constant;

import pkg.cty.employeemanagement.utils.TimeUtils;

import java.util.Date;

public class CommonConstant {
    public static final Date CURRENT_TIME = TimeUtils.getCurrentTime();

    public static final String LOGIN_MESSAGE = "loginMessage";
    public static final String INSERT_MESSAGE = "insertMessage";
    public static final String UPDATE_MESSAGE = "updateMessage";
    public static final String DELETE_MESSAGE = "deleteMessage";

    public static final String LOGIN_USER = "loginUser";
}
