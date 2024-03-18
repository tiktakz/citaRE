package com.citaproject.cita.dto.post;

import com.citaproject.cita.entity.Post;
import com.citaproject.cita.entity.User;
import com.citaproject.cita.enums.MBTI;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseDto {
    private String user;
    private String mbti;

    public PostResponseDto(Post post) {
        this.user = post.getUser().getStudentNo();
        this.mbti = post.getDescription();
    }
}
