package com.ritesh.studyhabitanalyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ritesh.studyhabitanalyzer.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}