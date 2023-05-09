package com.api.demo.service;

import com.api.demo.entity.User;
import com.api.demo.repository.UserRepository;
import com.api.demo.request.UserRequestDTO;
import com.api.demo.response.UserResponseDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void testAddStringTest() throws Exception {

        UserServiceImpl service = new UserServiceImpl(userRepository);

        //Given
        UserRequestDTO user = new UserRequestDTO();
        user.setFirstName("Kevin");
        user.setLastName("Burke");

        //When
        when(userRepository.save(Mockito.any(User.class))).thenReturn(new User(new Long(1), "Kevin", "Burke"));
        UserResponseDTO userAdded = service.addUser(user);

        //Then
        assertNotNull(userAdded.getId());
        assertEquals(userAdded.getFirstName(), "Kevin");
        assertEquals(userAdded.getLastName(), "Burke");

    }
}