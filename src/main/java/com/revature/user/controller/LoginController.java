package com.revature.user.controller;

import com.revature.user.model.User;
import com.revature.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    /**
     * @Author Tyler, Boualem, Jason
     * Constructor -> Injects needed dependencies
     * @param userService UserService dependency
     */
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @Author Tyler, Boualem, Jason
     * Method -> Checks a User that is logging in
     * @param user The info to be checked
     * @return The User after validation
     */
    @PostMapping
    public Integer checkLogin(@RequestBody User user) {
        User emptyUser = new User();
        if (user != null) {
            User dbUser = userService.findByUsername(user.getUsername());

            if (dbUser != null) // Check if User exists
            {
                if (userService.comparePassword(user.getPassword(), dbUser.getPassword()))  // Check password
                {
                    return dbUser.getId();  // User credentials match
                }
            }
        }

        return  0;    // Returns the User, has no ID if User had wrong password or doesn't exist
    }

}