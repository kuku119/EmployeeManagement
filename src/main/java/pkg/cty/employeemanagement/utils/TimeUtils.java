package pkg.cty.employeemanagement.utils;

import java.util.Date;

public class TimeUtils {
    public static Date getCurrentTime() {
        return new Date(System.currentTimeMillis());
    }
}
