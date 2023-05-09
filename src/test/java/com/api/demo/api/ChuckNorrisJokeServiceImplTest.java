package com.api.demo.api;

import com.api.demo.util.DemoConstants;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



@SpringBootTest
public class ChuckNorrisJokeServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Test
        public void testAddStringTest() throws Exception {

            ChuckNorrisJokeServiceImpl service = new ChuckNorrisJokeServiceImpl(restTemplate);

            //Given
            String joke = "{\"categories\":[],\"created_at\":\"2020-01-05 13:42:27.496799\",\"icon_url\":\"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\"id\":\"mRJJOTH7Sw21Uk4BdIKklg\",\"updated_at\":\"2020-01-05 13:42:27.496799\",\"url\":\"https://api.chucknorris.io/jokes/mRJJOTH7Sw21Uk4BdIKklg\",\"value\":\"CHUCK NORRIS CAN KILL TWO STONES WITH ONE BIRD\"}";

            //When
            ResponseEntity<String> responseEntity = new ResponseEntity<>(joke, HttpStatus.OK);
            when(restTemplate.exchange(eq(DemoConstants.JOKE_URL), eq(HttpMethod.GET), any(HttpEntity.class), eq(String.class)))
                .thenReturn(responseEntity);

            //Then
            assertEquals(service.getJokeValue(), "CHUCK NORRIS CAN KILL TWO STONES WITH ONE BIRD");

        }



}
