package com.citaproject.cita.entity;

import com.citaproject.cita.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private Integer duration;

    @Enumerated(EnumType.STRING)
    private MBTI mbti;

    @Column
    private String sleepTime;

    @Enumerated(EnumType.STRING)
    private ShareItem shareItem;

    @Enumerated(EnumType.STRING)
    private SleepHabit sleepHabit;

    @Enumerated(EnumType.STRING)
    private Smoke smoke;

    @Enumerated(EnumType.STRING)
    private FriendlyLevel friendlyLevel;

    @Lob
    @Column
    private String description;

    @ManyToOne
    @JoinColumn
    private User user;
}
