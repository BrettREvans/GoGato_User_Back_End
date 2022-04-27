package com.revature.user.service;

import com.revature.user.model.User;
import com.revature.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    UserRepository userRepository;

    /**
     * Sets a User's About Me text to a new value.
     *
     * @param user The User to update
     * @param aboutMeText The new aboutMe text
     * @return The saved user object
     * @author Asheton, Jazib
     */
    public User updateAboutMe(User user, String aboutMeText) {
        user.setAboutMe(aboutMeText);
        return userRepository.save(user);
    }

    /**
     * Sets a User's first and last name to a new value.
     *
     * @param user The User to update
     * @param firstName The new first name
     * @param lastName The new last name
     * @return The saved user object
     * @author Asheton, Jazib
     */
    public User updateName(User user, String firstName, String lastName){
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return userRepository.save(user);
    }
}
