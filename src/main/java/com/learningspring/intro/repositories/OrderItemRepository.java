package com.learningspring.intro.repositories;

import com.learningspring.intro.model.entities.OrderItem;
import com.learningspring.intro.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
