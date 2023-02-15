package com.user.mgmt.controller;

import com.user.mgmt.model.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping({"/user"})
public class UserController {

    static List<User> savedUsers = new ArrayList<>();

    @PostMapping
    public void addUser(@Validated @RequestBody User user) {
        savedUsers.add(user);

    }

    @GetMapping("/{socialSecurityNumber}")
    public Optional<User> getUserDetails(@PathVariable ("socialSecurityNumber") String socialSecurityNumber) {
        return savedUsers.stream().filter(user ->
                user.getSocialSecurityNumber().equalsIgnoreCase(socialSecurityNumber)).findFirst();

    }

    @GetMapping("/oldestChild/{socialSecurityNumber}")
    public Map<String,String> getUserOldestChild(@PathVariable ("socialSecurityNumber") String socialSecurityNumber) {
        Optional<User> userOptional = savedUsers.stream().filter(user ->
                user.getSocialSecurityNumber().equalsIgnoreCase(socialSecurityNumber)).findFirst();

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String childName = user.getChildren().entrySet().stream().max(Map.Entry.comparingByValue()).
                    map(Map.Entry::getKey).orElse(null);

            return new HashMap<>() {{
                put(user.getSocialSecurityNumber(), childName);
            }};
        }
        return new HashMap<>();


    }

}