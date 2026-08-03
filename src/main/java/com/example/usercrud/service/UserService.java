package com.example.usercrud.service;

import com.example.usercrud.dto.UserCreateRequest;
import com.example.usercrud.dto.UserResponse;
import com.example.usercrud.entity.User;
import com.example.usercrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(UserCreateRequest request) {

        User user = new User(request.getUsername(), request.getPassword());

        User saveUser = userRepository.save(user);

        return new UserResponse(saveUser.getId(), saveUser.getUsername());
        
    }

    public UserResponse getUser(Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        return new UserResponse(user.getId(), user.getUsername());
    }
}
