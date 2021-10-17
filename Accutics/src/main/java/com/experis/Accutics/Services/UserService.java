package com.experis.Accutics.Services;

import com.experis.Accutics.Models.User;
import com.experis.Accutics.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUsersByEmail(String email){
        return userRepository.getUsersByEmail(email);

    }

    public List<User> getUsersByName(String name){
        return userRepository.getUsersByName(name);
    }

}
