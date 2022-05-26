package com.learningspring.intro.services;

import com.learningspring.intro.model.entities.User;
import com.learningspring.intro.repositories.UserRepository;
import com.learningspring.intro.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
