package com.citaproject.cita.dto;

import com.citaproject.cita.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long id;
    private final String studentNo;
    private final String name;
    private final Integer schoolYear;
    private final String email;
    private final String password;

    // Entity -> DTO
    public UserResponseDto(User userEntity) {
        this.id = userEntity.getId();
        this.studentNo = hideStudentNumber(userEntity.getStudentNo());
        this.name = userEntity.getName();
        this.schoolYear = userEntity.getSchoolYear();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
    }

    private String hideStudentNumber(String studentNo) {
        String mask = "*****";
        String number = studentNo.substring(0, studentNo.length() - 5);
        return number + mask;
    }
}
