package com.citaproject.cita.controller;

import com.citaproject.cita.dto.post.PostRequestDto;
import com.citaproject.cita.dto.post.PostResponseDto;
import com.citaproject.cita.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    // POST 1
    @PostMapping(value = "/api/post/{id}" , consumes = "application/json", produces = "application/json")
    public ResponseEntity<PostResponseDto> savePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        PostResponseDto dto = postService.save(requestDto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }

    // Get Post
    @GetMapping("/api/post/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        //postService.findById(id);
        return null;
    }
}
