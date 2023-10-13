package pkg.cty.employeemanagement.pojo;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Date createTime;
    private Date updateTime;
    @NonNull
    private Integer employeeId;
    @NonNull
    private String name;
    private String email;
    private Integer gender;
    private Date birthday;
    @NonNull
    private Department department;

    public Employee(@NonNull Integer employeeId, @NonNull String name, String email, Integer gender, Date birthday, @NonNull Department department) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.department = department;
    }
}
