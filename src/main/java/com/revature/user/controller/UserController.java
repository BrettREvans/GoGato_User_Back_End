package com.revature.user.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.user.model.User;
import com.revature.user.repository.UserRepository;
import com.revature.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    UserRepository userRepository;

    /**
     * Creates the user through an HTTP request
     * @param user
     * @return a user profile
     */
    @PostMapping
    public User createNewUser(@RequestBody User user) {
        return userService.createNewUser(user); // returns user profile
    }
    /**
     * Retrieves a list of all users
     * @return a list of users
     */
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers(); // returns a list of users
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get user by ID or Username. If ID cannot be parsed as an integer, assume string and find by username.
     *
     * @param identifier
     * @return
     */
    @GetMapping("/{identifier}")
    public User findUserByIdOrUsername(@PathVariable String identifier) {
        try {
            Integer id = Integer.parseInt(identifier);
            return userService.findUserById(id);
        } catch (NumberFormatException e) {
            return userService.findUserByUsername(identifier);
        }
    }

    /**
     * Update a User's profile information.
     *
     * @param aboutMeObject New user information
     */
    @PutMapping("/profile/{identifier}")
    public void updateAboutMe(@PathVariable String identifier, @RequestBody ObjectNode aboutMeObject) {

        String aboutMeText = aboutMeObject.get("aboutMe").asText();

        User userToUpdate = new User();
        // Get the user to update by their ID or username
        try {
            Integer id = Integer.parseInt(identifier);
            userToUpdate = userService.findUserById(id);
        } catch (NumberFormatException e) {
            userToUpdate = userService.findUserByUsername(identifier);
        }

        userService.updateAboutMe(userToUpdate, aboutMeText);
    }
}