package com.api.demo.controller;

import com.api.demo.entity.User;
import com.api.demo.request.TestRequestDTO;
import com.api.demo.request.UserRequestDTO;
import com.api.demo.response.TestResponse;
import com.api.demo.response.UserResponseDTO;
import com.api.demo.service.TestService;
import com.api.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {


    private TestService testService = null;

    private UserService userService = null;

    public DemoController(TestService testService, UserService userService) {
        this.testService = testService;
        this.userService = userService;
    }

    @PostMapping(value= "/test")
    public TestResponse testEndPoint(@RequestBody TestRequestDTO request) {
        String id = request.getId();
        TestResponse response = null;
        try {
            response = testService.testAddString(id);
        } catch (Exception e){
            System.out.println("Test Service failure");
        }
        return response;
    }

    @GetMapping(value = "/getUsers")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public UserResponseDTO addUser(@RequestBody UserRequestDTO user) {
        return userService.addUser(user);
    }

}
