package com.citaproject.cita.service;

import com.citaproject.cita.dto.UserRequestDto;
import com.citaproject.cita.entity.User;
import com.citaproject.cita.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-dev.properties")
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    void validateUser() {

        UserRequestDto u1 = new UserRequestDto("2","kim", 4, "2313", "1234");
        UserRequestDto u2 = new UserRequestDto("2","kim", 4, "test", "1234");

        userService.join(u1);
//        userService.join(u2);
    }
}