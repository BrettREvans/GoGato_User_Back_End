package com.revature.user.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.user.model.User;
import com.revature.user.service.ProfileService;
import com.revature.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @Autowired
    UserService userService;

    /**
     * Update a User's profile information.
     *
     * @param aboutMeObject New user information
     * @author Asheton, Jazib
     */
    @PutMapping("/{identifier}")
    public void updateAboutMe(@PathVariable String identifier, @RequestBody ObjectNode aboutMeObject) {

        String aboutMeText = aboutMeObject.get("aboutMe").asText();

        User userToUpdate = new User();
        // Get the user to update by their ID or username
        try {
            Integer id = Integer.parseInt(identifier);
            userToUpdate = userService.findUserById(id);
        } catch (NumberFormatException e) {
            userToUpdate = userService.findByUsername(identifier);
        }

        profileService.updateAboutMe(userToUpdate, aboutMeText);
    }
}
