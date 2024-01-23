package com.citaproject.cita.repository;

import com.citaproject.cita.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByStudentNo(String studentNo);

    boolean existsUserByStudentNo(String studentNo);

    boolean existsUserByEmail(String email);
}
