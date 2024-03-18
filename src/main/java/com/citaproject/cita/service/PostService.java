package com.citaproject.cita.service;

import com.citaproject.cita.dto.post.PostRequestDto;
import com.citaproject.cita.dto.post.PostResponseDto;
import com.citaproject.cita.entity.Post;
import com.citaproject.cita.repository.PostRepository;
import com.citaproject.cita.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    public PostResponseDto save(PostRequestDto requestDto, Long id) {
        System.out.println(requestDto);
        requestDto.setUser(userRepository.findById(id).orElse(null));
        System.out.println(requestDto);
        if (requestDto.getUser() != null) {
            Post post = postRepository.save(requestDto.toEntity());
            return new PostResponseDto(post);
        }
        return null;
    }
}
