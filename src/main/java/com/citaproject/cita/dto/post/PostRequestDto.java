package com.citaproject.cita.dto.post;

import com.citaproject.cita.entity.Post;
import com.citaproject.cita.entity.User;
import com.citaproject.cita.enums.*;
import com.citaproject.cita.service.UserService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostRequestDto {
    private User user;
    private Integer age;
    private Gender gender;
    private Integer duration;
    private MBTI mbti;
    private String sleepTime;
    private ShareItem shareItem;
    private SleepHabit sleepHabit;
    private Smoke smoke;
    private FriendlyLevel friendlyLevel;
    private String description;

    public Post toEntity() {
        return Post.builder()
                .user(user)
                .age(age)
                .gender(gender)
                .duration(duration)
                .mbti(mbti)
                .sleepTime(sleepTime)
                .shareItem(shareItem)
                .sleepHabit(sleepHabit)
                .smoke(smoke)
                .friendlyLevel(friendlyLevel)
                .description(description)
                .build();
    }
}
