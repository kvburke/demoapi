package com.api.demo.service;

import com.api.demo.entity.User;
import com.api.demo.request.UserRequestDTO;
import com.api.demo.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public UserResponseDTO addUser(UserRequestDTO user);

}
