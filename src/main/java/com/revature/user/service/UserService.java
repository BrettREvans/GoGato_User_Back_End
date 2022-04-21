package com.revature.user.service;

import com.revature.user.model.User;
import com.revature.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id).orElse(new User());

//        Throw(() -> new RuntimeException("User not found."));
    }

    /**
     *
     * @param user
     * @return a completed registration form
     */
    public User createNewUser(User user)
    {
        user.setPassword((user.getPassword()));
        System.out.println(user.getPassword());
        return userRepository.save(user);  // returns a user profile
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found."));
    }
}