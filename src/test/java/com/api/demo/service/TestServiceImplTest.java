package com.api.demo.service;

import com.api.demo.api.ChuckNorrisJokeService;
import com.api.demo.response.TestResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestServiceImplTest {

    @Mock
    private ChuckNorrisJokeService chuckNorrisJokeService;

    @Test
    public void testAddStringTest() throws Exception {

        TestServiceImpl service = new TestServiceImpl(chuckNorrisJokeService);

        //Given
        String id = "123";

        //When
        when(chuckNorrisJokeService.getJokeValue()).thenReturn("xxx");
        TestResponse response = service.testAddString(id);

        //Then
        TestResponse exceptedResponse = new TestResponse("123","xxx");
        assertEquals(response.getId(), exceptedResponse.getId());
        assertEquals(response.getTestString(), exceptedResponse.getTestString());

    }

    @Test
    public void testAddStringTestException() throws Exception {

        String id ="123";

        when(chuckNorrisJokeService.getJokeValue()).thenThrow(new Exception());
        TestService service = new TestServiceImpl(chuckNorrisJokeService);

        assertThrows(Exception.class, () -> {
            service.testAddString(id);
        });
    }

}
