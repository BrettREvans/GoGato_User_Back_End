package com.revature.user.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.user.model.User;
import com.revature.user.service.ProfileService;
import com.revature.user.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This controller handles requests to modify information that may appear on a user's profile page.
 */
@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @Autowired
    UserService userService;

    /**
     * Update a User's About Me.
     *
     * @param aboutMeObject New user information
     * @author Asheton, Jazib
     */
    @Parameter(description = "Update a User's about me")
    @PutMapping("/{identifier}/about")
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

    /**
     * Update a User's first name and last name in profile.
     *
     * @author Asheton, Jazib
     */

    @Parameter(description = "Update a User's Name")
    @PutMapping("/{identifier}/name")
    public void updateName(@PathVariable String identifier, @RequestParam String firstName, @RequestParam String lastName) {

        User userToUpdate = new User();
        // Get the user to update by their ID or username
        try {
            Integer id = Integer.parseInt(identifier);
            userToUpdate = userService.findUserById(id);
        } catch (NumberFormatException e) {
            userToUpdate = userService.findByUsername(identifier);
        }

        if (firstName == "") {
            firstName = userToUpdate.getFirstName();
        }

        if (lastName == "") {
            lastName = userToUpdate.getLastName();
        }

        profileService.updateName(userToUpdate, firstName, lastName);
    }


}
