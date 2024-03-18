package com.citaproject.cita.repository;

import com.citaproject.cita.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
