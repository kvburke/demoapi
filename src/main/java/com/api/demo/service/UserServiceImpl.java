package com.api.demo.service;

import com.api.demo.entity.User;
import com.api.demo.repository.UserRepository;
import com.api.demo.request.UserRequestDTO;
import com.api.demo.response.UserResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private static UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserResponseDTO addUser(UserRequestDTO user) {
        User userobj = new User();
        Long id= user.getId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String password = user.getPassword();

        userobj.setId(id);
        userobj.setFirstName(firstName);
        userobj.setLastName(lastName);
        User obj = userRepository.save(userobj);
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(obj.getId());
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setEmail(email);
        dto.setPassword(password);
        return dto;
    }

}
