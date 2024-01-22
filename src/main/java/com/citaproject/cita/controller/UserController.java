package com.citaproject.cita.controller;

import com.citaproject.cita.dto.UserRequestDto;
import com.citaproject.cita.dto.UserResponseDto;
import com.citaproject.cita.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // POST Users
    @PostMapping("/api/user/join")
    public UserResponseDto joinUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.join(userRequestDto);
    }

    // GET Users
    @GetMapping("/api/user/{id}")
    public UserResponseDto showInfo(@PathVariable Long id) {
        // TODO: 만약 사용자가 없으면 어떻게 할거야? 단순 서버 에러 말고 메시지 표현
        return userService.getDetail(id);
    }

    // Delete User
    @DeleteMapping("/api/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
