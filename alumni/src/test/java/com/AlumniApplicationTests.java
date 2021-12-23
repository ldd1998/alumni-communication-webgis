package com;

import com.entity.Login;
import com.mapper.LoginMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AlumniApplicationTests {

    @Autowired
    private LoginMapper loginMapper;
    
    @Test
    void contextLoads() {
        Login login = loginMapper.selectAllLogin();
        System.out.println(login);
    }


}
