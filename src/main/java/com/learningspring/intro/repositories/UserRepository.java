package com.learningspring.intro.repositories;

import com.learningspring.intro.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
