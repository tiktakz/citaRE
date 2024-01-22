package com.citaproject.cita.dto;

import com.citaproject.cita.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private Integer studentNo;
    private String name;
    private Integer schoolYear;
    private String email;
    private String password;

    // Entity -> DTO
    public UserResponseDto(User userEntity) {
        this.id = userEntity.getId();
        this.studentNo = userEntity.getStudentNo();
        this.name = userEntity.getName();
        this.schoolYear = userEntity.getSchoolYear();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
    }
}
