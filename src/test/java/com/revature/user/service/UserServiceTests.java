package com.revature.user.service;

import com.revature.user.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // webEnvironment creates a temporary web server port to run requests/responses through
public class UserServiceTests {


    @LocalServerPort
    private int port;           // Port to use in webEnvironment

    @Autowired
    UserService userService;  //service to use

    @Test
    public void TestClassWorks()
    {
        assertTrue(true);
    }

    @Test
    @DisplayName("Test to update profile text")
    public void updateProfileTest(){

        User userTest = new User();




    }
}
