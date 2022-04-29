package com.revature.user.controller;

import com.revature.user.model.User;
import com.revature.user.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * This controller handles requests to log into the application.
 */
@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    /**
     * This constructor will inject the dependencies needed from the service layer.
     *
     * @param userService UserService dependency
     * @author Tyler, Boualem, Jason
     */
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Will check the current user logging in and compare with database credentials.
     *
     * @param user The info to be checked
     * @return The User after validation
     * @author Tyler, Boualem, Jason
     */
    @PostMapping
    public Integer checkLogin(@RequestBody User user) {
        User emptyUser = new User();
        if (user != null) {
            User dbUser = userService.findByUsername(user.getUsername());
            // Check if User exists
            if (dbUser != null) {
                // Check password
                if (userService.comparePassword(user.getPassword(), dbUser.getPassword())) {
                    // User credentials match
                    return dbUser.getId();
                }
            }
        }
        // Returns the User, has no ID if User had wrong password or doesn't exist
        return 0;
    }

}