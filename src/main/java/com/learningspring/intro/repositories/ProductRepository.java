package com.learningspring.intro.repositories;

import com.learningspring.intro.model.entities.Product;
import com.learningspring.intro.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
