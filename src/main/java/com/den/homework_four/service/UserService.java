package com.den.homework_four.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.den.homework_four.model.User;
import com.den.homework_four.repos.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class UserService {
    /*Объект репозитория для работы с БД*/
    private final UserRepository userRepository;

    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }
}