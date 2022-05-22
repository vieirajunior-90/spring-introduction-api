package com.learningspring.intro.repositories;

import com.learningspring.intro.model.entities.Category;
import com.learningspring.intro.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
