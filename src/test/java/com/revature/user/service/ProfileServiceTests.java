package com.revature.user.service;

import com.revature.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfileServiceTests {
    @Autowired
    ProfileService profileService;


    User testUser = new User(0,
            "ctester",
            "pass",
            0,
            0,
            "Chester",
            "Tester",
            "ctester@test.com",
            "");


    /**
     * Assert equals "Hello, world!" after being updated
     */
    @Test
    public void updateAboutMeTest() {
        assertEquals(profileService.updateAboutMe(testUser, "Hello, world!").getAboutMe(), "Hello, world!");
    }
}
