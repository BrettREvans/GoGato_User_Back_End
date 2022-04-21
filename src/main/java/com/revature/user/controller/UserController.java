package com.revature.user.controller;

import com.revature.user.model.User;
import com.revature.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Creates the user through an HTTP request
     * @param user
     * @return
     */
    @PostMapping
    public User createNewUser(@RequestBody User user) {
        return userService.createNewUser(user); // returns user profile
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // /users/mickey
    @GetMapping("/{identifier}")
    public User findUserByIdOrUsername(@PathVariable String identifier) {
        try {
            Integer id = Integer.parseInt(identifier);

            return userService.findUserById(id);
        } catch (NumberFormatException e) {
            // we know that the identifier string is not a number, so we can use it as a username
            return userService.findUserByUsername(identifier);
        }
    }

}