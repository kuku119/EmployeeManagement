package pkg.cty.employeemanagement.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkg.cty.employeemanagement.dao.UserMapper;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUserPassword() {
        System.out.println(userMapper.getUser("admin"));
        System.out.println(userMapper.getUser("mgt"));
    }
}