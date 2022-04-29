package com.revature.user.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.user.model.User;
import com.revature.user.repository.UserRepository;
import com.revature.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller handles requests to create, retrieve, and update the stats of a User.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    UserRepository userRepository;

    /**
     * Creates the user through an HTTP request
     *
     * @param user
     * @return a user profile
     * @author Tyler, Boualem, Jason
     */
    @PostMapping
    public User createNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    /**
     * Retrieves a list of all users
     *
     * @return a list of users
     * @author Tyler, Boualem, Jason
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get user by ID or Username. If ID cannot be parsed as an integer, assume string and find by username.
     *
     * @param identifier
     * @return
     * @author Tyler, Boualem, Jason, Marcus
     */
    @GetMapping("/{identifier}")
    public User findUserByIdOrUsername(@PathVariable String identifier) {
        try {
            Integer id = Integer.parseInt(identifier);
            return userService.findUserById(id);
        } catch (NumberFormatException e) {
            // Assume identifier is a string username
            return userService.findByUsername(identifier);

        }
    }

    /**
     * Updates a User's point amount
     *
     * @param pointsObj New user information
     * @author Christian, Asheton
     */
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

    /**
     * Updates a User's post amount
     *
     * @param postsObj New user information
     * @author Christian
     */
    @PutMapping("/{identifier}/posts")
    public void updatePosts(@PathVariable String identifier, @RequestBody ObjectNode postsObj) {

        int userId = postsObj.get("id").asInt();
        int posts = postsObj.get("posts").asInt();

        User userToUpdate = new User();
        // Get the user to update by their ID or username
        try {
            Integer id = Integer.parseInt(identifier);
            userToUpdate = userService.findUserById(id);
        } catch (NumberFormatException e) {
            userToUpdate = userService.findByUsername(identifier);
        }

        userService.updatePosts(userToUpdate, posts);
    }
}