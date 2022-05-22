package com.learningspring.intro.config;

import com.learningspring.intro.model.entities.Order;
import com.learningspring.intro.model.entities.User;
import com.learningspring.intro.model.entities.enums.OrderStatus;
import com.learningspring.intro.repositories.OrderRepository;
import com.learningspring.intro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User U1 = new User(
                "Pedro Carvalho",
                "pedrocarvalho@gmail.com",
                "(21)98732-1234",
                "123456");

        User U2 = new User(
                "Maria Silva",
                "mariasilva@outlook.com",
                "(19)98765-4321",
                "654321");

        User U3 = new User(
                "João Camargo",
                "joaocamargo@gmail.com",
                "(24)98434-6543",
                "222444");

        User U4 = new User(
                "Fernanda Oliveira",
                "fernandaoliveira@yahoo.com.br",
                "(11)99882-1234",
                "909023");

        User U5 = new User(
                "Adriana de Jesus",
                "jesusadriana@gmail.com",
                "(11)99333-0099",
                "987634");

        Order O1 = new Order(
                Instant.parse("2022-06-20T19:53:07Z"),
                OrderStatus.PAID,
                U1);

        Order O2 = new Order(
                Instant.parse("2022-07-20T15:21:00Z"),
                OrderStatus.WAITING_PAYMENT,
                U2);

        Order O3 = new Order(
                Instant.parse("2022-08-20T12:00:00Z"),
                OrderStatus.WAITING_PAYMENT,
                U1);

        Order O4 = new Order(
                Instant.parse("2022-08-12T10:04:05Z"),
                OrderStatus.CANCELED,
                U3);

        Order O5 = new Order(
                Instant.parse("2022-08-12T20:13:15Z"),
                OrderStatus.SHIPPED,
                U5);


        userRepository.saveAll(Arrays.asList(U1, U2, U3, U4, U5));
        orderRepository.saveAll(Arrays.asList(O1, O2, O3, O4, O5));

    }
}
