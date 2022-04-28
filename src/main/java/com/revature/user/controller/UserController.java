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
     * @author Tyler, Boualem, Jason
     * @param user
     * @return a user profile
     */
    @PostMapping
    public User createNewUser(@RequestBody User user) {
        return userService.createNewUser(user); // returns user profile
    }
    /**
     * Retrieves a list of all users
     * @author Tyler, Boualem, Jason
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
     *@author Tyler, Boualem, Jason, Marcus
     * @param identifier
     * @return
     */
    @GetMapping("/{identifier}")
    public User findUserByIdOrUsername(@PathVariable String identifier) {
        try {
            Integer id = Integer.parseInt(identifier);
            return userService.findUserById(id);
        } catch (NumberFormatException e) {

            // we know that the identifier string is not a number, so we can use it as a username
            return userService.findByUsername(identifier);

        }
    }

    @PutMapping("/{identifier}/points")
    public void updatePoints(@PathVariable String identifier, @RequestBody ObjectNode pointsObj) {

        int userId = pointsObj.get("id").asInt();
        int points = pointsObj.get("points").asInt();

        User userToUpdate = new User();
        // Get the user to update by their ID or username
        try {
            Integer id = Integer.parseInt(identifier);
            userToUpdate = userService.findUserById(id);
        } catch (NumberFormatException e) {
            userToUpdate = userService.findByUsername(identifier);
        }

        userService.updatePoints(userToUpdate, points);
    }

    @PutMapping("/{identifier}/posts")
    public void updatePosts()
    {

    }
}