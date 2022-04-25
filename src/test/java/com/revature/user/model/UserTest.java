package com.revature.user.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest
{
    /**
     * @author Tyler, Boualem, Jason
     * Makes sure the test class works
     */
    @Test
    public void TestClassWorks()
    {
        assertTrue(true);
    }

    /**
     * @author Tyler, Boualem, Jason
     * Makes sure you can create new user objects
     */
    @Test
    @DisplayName("Test for the creation of a new User")
    public void canCreateANewUserObj()
    {
        User u = new User();

        assertNotNull(u);
    }


    /**
     * @author Tyler, Boualem, Jason
     * Make sure that registration fields are working
     */

    @Test
    public void TestUsersField(){
    User u = new User();
    u.setId(1);
    u.setUsername("Test");
    u.setPassword("Test");
    u.setFirstName("Test");
    u.setLastName("Test");
    u.setEmail("test@test.com");
    u.setAboutMe("This is a test");

    assertEquals(1, u.getId());
    assertEquals("Test", u.getUsername());
    assertEquals("Test", u.getPassword());
    assertEquals("Test", u.getFirstName());
    assertEquals("Test", u.getLastName());
    assertEquals("test@test.com", u.getEmail());
    assertEquals("This is a test", u.getAboutMe());
    }

}
