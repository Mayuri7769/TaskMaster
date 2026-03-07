package com.task.taskmanager.controller;


import com.task.taskmanager.entity.User;
import com.task.taskmanager.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test(Authentication authentication) {
        return "Logged in user: " + authentication.getName();
    }

    @GetMapping("/profile")
    public User getProfile(Authentication authentication) {

        String email = authentication.getName();

        return userService.getUserProfile(email);
    }

    @PutMapping("/profile")
    public User updateProfile(
            Authentication authentication,
            @RequestBody User updatedUser
    ) {

        String email = authentication.getName();

        return userService.updateProfile(email, updatedUser);
    }
}
