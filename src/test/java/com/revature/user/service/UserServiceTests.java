package com.revature.user.service;

import com.revature.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


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
    public void updateAboutMeTest(){

        User userTest = new User();




    }



    /**
     * @author Marcus, Jason, Tyler
     */
    @Test
    @DisplayName("Test to create/persist a new User")
    public void persistANewUserWithCreateNewUserMethod()
    {
        // Create a User object
        User userTest = new User();
        userTest.setUsername("Test");
        userTest.setPassword("Test");
        userTest.setFirstName("Test");
        userTest.setLastName("Test");
        userTest.setEmail("test@test.com");
        userTest.setAboutMe("This is a test");

        // Persist user
        User savedUser = userService.createNewUser(userTest);

        // Check values
        assertNotNull(savedUser);
        assertEquals("Test", savedUser.getUsername());
    }

    /** Retrieving all the users that are in a database
     *
     * @author Marcus, Jason, Tyler
     */
    @Test
    @DisplayName("Test for getting all Users")
    public void retrieveAllPersistedUsers()
    {
        // Create a User object
        User userTest = new User();
        userTest.setUsername("Test");
        userTest.setPassword("Test");
        userTest.setFirstName("Test");
        userTest.setLastName("Test");
        userTest.setEmail("test@test.com");
        userTest.setAboutMe("This is a test");

        // Create another User object
        User userTest2 = new User();
        userTest2.setUsername("Test");
        userTest2.setPassword("Test");
        userTest2.setFirstName("Test");
        userTest2.setLastName("Test");
        userTest2.setEmail("test@test.com");
        userTest2.setAboutMe("This is a test");

        // Collect Users
        List<User> actualUserList = new ArrayList<>();
        actualUserList.add(userTest);
        actualUserList.add(userTest2);

        // Persist user
        userService.createNewUser(userTest);
        userService.createNewUser(userTest2);

        // Retrieve Users from DB
        List<User> retrievedUsers = userService.getAllUsers();

        // Check values
        assertNotNull(retrievedUsers);

        if (retrievedUsers != null)
        {
            // Check values based on before/after DB persistence
            for (int i = 0; i < retrievedUsers.size(); i++)
            {
                assertEquals(actualUserList.get(i).getUsername(), retrievedUsers.get(i).getUsername());
            }
        }
    }

    /** Finding a specific user based on their User ID
     *
     * @author Marcus, Jason, Tyler
     */
    @Test
    @DisplayName("Test for getting a User by their ID")
    public void findAUserByTheirID()
    {
        // Create a User object
        User userTest = new User();
        userTest.setUsername("Test");
        userTest.setPassword("Test");
        userTest.setFirstName("Test");
        userTest.setLastName("Test");
        userTest.setEmail("test@test.com");
        userTest.setAboutMe("This is a test");

        // Persist user
        userTest = userService.createNewUser(userTest);

        // Find a User based on an ID
        User retrievedUser = userService.findUserById(userTest.getId());

        // Check values
        assertNotNull(retrievedUser);
        assertEquals(userTest.getEmail(), retrievedUser.getEmail());
    }

    /** Finding a User by Username
     * @author Marcus, Jason, Tyler, Boualem
     */
    @Test
    @DisplayName("Test for getting a User by their Username")
    public void findAUserByTheirUsername()
    {
        // Create a User object
        User userTest = new User();
        userTest.setUsername("Test");
        userTest.setPassword("Test");
        userTest.setFirstName("Test");
        userTest.setLastName("Test");
        userTest.setEmail("test@test.com");
        userTest.setAboutMe("This is a test");

        // Persist user
        userTest = userService.createNewUser(userTest);

        // Find a User based on a username
        User retrievedUser = userService.findByUsername(userTest.getUsername());

        // Check values
        assertNotNull(retrievedUser);
        assertEquals(userTest.getEmail(), retrievedUser.getEmail());
    }

    /**
     *
     * @author Marcus, Jason, Tyler, Boualem
     */
    @Test
    @DisplayName("Test password encryption")
    public void compareEncryptedPasswords()
    {
        // Create a User object
        User userTest = new User();
        userTest.setUsername("Test");
        userTest.setPassword("Test");
        userTest.setFirstName("Test");
        userTest.setLastName("Test");
        userTest.setEmail("test@test.com");
        userTest.setAboutMe("This is a test");

        // Persist user
        userService.createNewUser(userTest);

        // Retrieve a User by username -> only have username and password during login
        User retrievedUser = userService.findByUsername(userTest.getUsername());

        // Compare login credentials with DB credentials
        assertTrue(userService.comparePassword("Test", retrievedUser.getPassword()));
    }


}
