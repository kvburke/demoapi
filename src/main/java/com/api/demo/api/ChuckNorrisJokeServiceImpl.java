package com.api.demo.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import com.api.demo.util.DemoConstants;

@Service
public class ChuckNorrisJokeServiceImpl implements ChuckNorrisJokeService {

    private final RestTemplate restTemplate;

    public ChuckNorrisJokeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getJokeValue() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.ALL));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> response = null;
        String apiUrl = "https://api.chucknorris.io/jokes/random";
        try {
            response = restTemplate.exchange(DemoConstants.JOKE_URL, HttpMethod.GET, entity, String.class);
        }catch (Exception e){
            throw new Exception("Failed Chuck Norris service call.");
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            return root.get("value").asText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Chuck Norris joke response.", e);
        }
    }
}
