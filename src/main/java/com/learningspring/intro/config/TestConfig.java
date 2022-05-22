package com.learningspring.intro.config;

import com.learningspring.intro.model.entities.User;
import com.learningspring.intro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

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


        userRepository.saveAll(Arrays.asList(U1, U2));
    }
}
