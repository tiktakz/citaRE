package com.citaproject.cita.service;

import com.citaproject.cita.dto.UserRequestDto;
import com.citaproject.cita.dto.UserResponseDto;
import com.citaproject.cita.entity.User;
import com.citaproject.cita.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // POST
    public UserResponseDto join(UserRequestDto requestDto) {
        if (validateUser(requestDto)) {
            User joinedUser = userRepository.save(requestDto.toEntity());
            return new UserResponseDto(joinedUser);
        }
        return null;
    }

    // GET
    public UserResponseDto getDetail(Long id) {
        User findUser = userRepository.findById(id).orElse(null);
        return new UserResponseDto(findUser);
    }

    // DELETE
    public void delete(Long id) {
        User deleteUser = userRepository.findById(id)
                .orElseThrow(
                        IllegalArgumentException::new
                );
        userRepository.delete(deleteUser);
    }

    private boolean validateUser(UserRequestDto requestDto) {
        // RequestDto를 보고 이미 가입한 유저인지 확인
        User requestedUser = userRepository.findByStudentNo(requestDto.getStudentNo()).orElse(null);
        return requestedUser == null;

        // TODO: 1. StudentNo 유효범위 확인, 중복 이메일 확인, 이름 확인
    }
}
