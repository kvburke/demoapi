package com.api.demo.service;

import com.api.demo.api.ChuckNorrisJokeService;
import com.api.demo.response.TestResponse;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {


    private final ChuckNorrisJokeService chuckNorrisJokeService;

    public TestServiceImpl(ChuckNorrisJokeService chuckNorrisJokeService) {
        this.chuckNorrisJokeService = chuckNorrisJokeService;
    }

    public TestResponse testAddString(String id) throws Exception {
        String generatedValue = "";
        try {
            generatedValue = chuckNorrisJokeService.getJokeValue();
        } catch (Exception e){
            System.out.println("Service failure.");
            throw new Exception();
        }
        TestResponse response = new TestResponse(id, generatedValue);
        return response;
    }

}
