package pkg.cty.employeemanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Date createTime;
    private Date updateTime;
    private String username;
    private String password;
    private Integer permission;
    // select: 0001 (1)
    // insert: 0010 (2)
    // update: 0100 (4)
    // delete: 1000 (8)
}
