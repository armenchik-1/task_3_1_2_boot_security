package ru.kata.spring.boot_security.demo.repository;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    void save(User user);
    User getById(int id);
    void deleteById(int id);
    User getByUsername(String username);
}
