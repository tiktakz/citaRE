package com.citaproject.cita.repository;

import com.citaproject.cita.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-dev.properties")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("유저 정보 테스트")
    void insertUserTest() {

        User user1 = User.builder()
                .id(1L)
                .email("test@test")
                .name("Test")
                .password("1234")
                .schoolYear(3)
                .build();

        User savedUser = userRepository.save(user1);
        System.out.println(savedUser);

        User findUser = userRepository.findById(1L).orElse(null);
        if (findUser != null) {
            assertEquals(savedUser.getId(), findUser.getId());
        }
    }

}