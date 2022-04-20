package com.revature.user.controller;

import com.revature.user.model.User;
import com.revature.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User createNewUser(@RequestBody User user){
        return userService.createNewUser(user);
    }

    @GetMapping("/{identifier}")
    public User findUserByIdOrUsername(@PathVariable String identifier){

        try{
            Integer id = Integer.parseInt(identifier);

            return userService.findUserById(id);
        } catch(NumberFormatException e){
            return userService.findUserByUsername(identifier);
        }
    }

}