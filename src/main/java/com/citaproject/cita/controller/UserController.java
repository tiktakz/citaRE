package com.citaproject.cita.controller;

import com.citaproject.cita.dto.UserRequestDto;
import com.citaproject.cita.dto.UserResponseDto;
import com.citaproject.cita.entity.User;
import com.citaproject.cita.service.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// TODO: 1/23/24  예외처리를 Controller에서할지 아니면 Service Layer에서 할지, controller에서는 서비스로직 하나만 호출?
// TODO: 1/23/24  Exception Handling 조금 더 신경쓰고 코드 다듬기 + 로직 
@RestController
@Validated // 이거 없어도 되어야하는데..
public class UserController {

    @Autowired
    UserService userService;

    // POST Users
    @PostMapping("/api/user/join")
    public ResponseEntity<UserResponseDto> joinUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto dto = userService.join(userRequestDto);
        // 바로 User객체를 돌려주면, user이 없는 경우에 에러만 표시. 상태코드별로 리턴하게 만들자
        // 지금은 제대로 들어온다고 생각했으니 OK. Service계층에서 오류 던져
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    // GET 1 User
    @GetMapping("/api/user/{id}")
    public ResponseEntity<UserResponseDto> showUser(@PathVariable Long id) {
        // TODO: 만약 사용자가 없으면 어떻게 할거야? 단순 서버 에러 말고 메시지 표현
        UserResponseDto dto = userService.show(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    // GET ALL Users
    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponseDto>> showAllUsers() {
        List<UserResponseDto> userList = userService.showAll();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    // Delete User
    @DeleteMapping("/api/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
