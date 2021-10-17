package com.experis.Accutics.Controllers;

import com.experis.Accutics.Models.User;
import com.experis.Accutics.Repositories.InputRepository;
import com.experis.Accutics.Repositories.UserRepository;
import com.experis.Accutics.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InputRepository inputRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> data = userRepository.findAll();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(data, status);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User add = userRepository.save(user);
        HttpStatus status;
        status = HttpStatus.CREATED;
        return new ResponseEntity<>(add, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getSpecificUser(@PathVariable Long id) {
        HttpStatus status;
        User add = new User();
        if (!userRepository.existsById(id)){
            status = HttpStatus.NOT_FOUND;
            return new ResponseEntity<>(add, status);
        }
        add = userRepository.findById(id).get();
        status = HttpStatus.OK;
        return new ResponseEntity<>(add, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateFranchise(@PathVariable("id") Long id, @RequestBody User user) {
        Optional<User> userData = userRepository.findById(id);
        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setName(user.getName());
            _user.setEmail(user.getEmail());

            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFranchise(@PathVariable("id") long id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getbyemail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        User user = userService.getUsersByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }


    }


    @GetMapping("/getbyname/{name}")
    public ResponseEntity<List<User>> findUserByNameContains(@PathVariable("name") String name) {
        List<User> users = userService.getUsersByName(name);
        if (users == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(users);
        }


    }



}
