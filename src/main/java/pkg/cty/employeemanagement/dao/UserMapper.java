package pkg.cty.employeemanagement.dao;

import org.apache.ibatis.annotations.Mapper;
import pkg.cty.employeemanagement.pojo.User;

@Mapper
public interface UserMapper {
    User getUser(String username);
}
