package com.citaproject.cita.dto;

import com.citaproject.cita.entity.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter

public class UserRequestDto {

    // Request DTO Fields
    @Pattern(regexp ="\\d{9}", message = "학번은 9자리입니다")
    private String studentNo;

    @NotBlank
    private String name;

    @DecimalMin(value = "1", inclusive = true)
    @DecimalMax(value = "4", inclusive = true)
    private Integer schoolYear;

    @Email
    private String email;

    @NotBlank
    @Min(8)
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
