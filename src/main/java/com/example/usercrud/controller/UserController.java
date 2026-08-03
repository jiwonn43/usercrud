package com.example.usercrud.controller;

import com.example.usercrud.dto.UserCreateRequest;
import com.example.usercrud.dto.UserResponse;
import com.example.usercrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserCreateRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/{user-id}")
    public UserResponse getUser(@PathVariable("user-id") Integer id) {
        return userService.getUser(id);
    }
}
