package pkg.cty.employeemanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Date createTime;
    private Date updateTime;
    @NonNull
    private Integer departmentId;
    @NonNull
    private String name;
}
