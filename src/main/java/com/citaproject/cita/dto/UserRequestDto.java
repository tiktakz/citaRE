package com.citaproject.cita.dto;

import com.citaproject.cita.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    // Request DTO Fields
    private Integer studentNo;
    private String name;
    private Integer schoolYear;
    private String email;
    private String password;

    // DTO -> Entity
    public User toEntity() {
        return User.builder()
                .studentNo(studentNo)
                .name(name)
                .schoolYear(schoolYear)
                .email(email)
                .password(password)
                .build();
    }

}
