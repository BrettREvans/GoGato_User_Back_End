package com.revature.user.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.user.model.User;
import com.revature.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
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