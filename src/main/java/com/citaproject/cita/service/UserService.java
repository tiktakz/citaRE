package com.citaproject.cita.service;

import com.citaproject.cita.dto.UserRequestDto;
import com.citaproject.cita.dto.UserResponseDto;
import com.citaproject.cita.entity.User;
import com.citaproject.cita.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // POST
    public UserResponseDto join(UserRequestDto requestDto) {
        validateUser(requestDto);
        User joinedUser = userRepository.save(requestDto.toEntity());
        return new UserResponseDto(joinedUser);
    }

    // GET
    public UserResponseDto show(Long id) {
        User findUser = userRepository.findById(id).orElse(null);
        return new UserResponseDto(findUser);
    }

    // GET ALL
    public List<UserResponseDto> showAll() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponseDto(user))
                .collect(Collectors.toList());
    }

    // DELETE
    public void delete(Long id) {
        User deleteUser = userRepository.findById(id)
                .orElseThrow(
                        IllegalArgumentException::new
                );
        userRepository.delete(deleteUser);
    }

    private void validateUser(UserRequestDto requestDto) {
        // RequestDto를 보고 이미 가입한 유저인지 확인
        // TODO: 1/23/24 Exception 사용자 정의
        if (requestDto == null) throw new IllegalArgumentException("User is null");

        if (userRepository.existsUserByEmail(requestDto.getEmail())) throw new IllegalArgumentException("Email is used");

        if (userRepository.existsUserByStudentNo(requestDto.getStudentNo())) throw new IllegalArgumentException("Student exist");

    }
}
