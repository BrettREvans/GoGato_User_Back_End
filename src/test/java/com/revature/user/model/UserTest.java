package com.revature.user.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * This class contains tests to ensure that the User model class is working.
 *
 */
@SpringBootTest
public class UserTest
{
    /**
     * Makes sure the test class is working.
     *
     * @author Tyler, Boualem, Jason
     */
    @Test
    public void TestClassWorks()
    {
        assertTrue(true);
    }

    /**
     * Makes sure that a new User object is being created.
     *
     * @author Tyler, Boualem, Jason
     */
    @Test
    @DisplayName("Test for the creation of a new User")
    public void canCreateANewUserObj()
    {
        User u = new User();

        assertNotNull(u);
    }


    /**
     * Tests to validate that registration fields are working.
     *
     * @author Tyler, Boualem, Jason
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
