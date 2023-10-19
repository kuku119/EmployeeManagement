package pkg.cty.employeemanagement.service;

import org.springframework.stereotype.Service;
import pkg.cty.employeemanagement.dao.UserMapper;
import pkg.cty.employeemanagement.pojo.User;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {
        return userMapper.getUser(username);
    }

}
