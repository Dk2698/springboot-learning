package com.kumar.book.service;

import com.kumar.book.model.User;
import com.kumar.book.repository.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @CachePut(value = "users", key = "#result.id")
    public User create(User user) {
        return repo.save(user);
    }

    public List<User> all() {
        return repo.findAll();
    }

    @Cacheable(value = "users", key = "#id")
    public User findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @CachePut(value = "users", key = "#id")
    public User update(Long id, User newUser) {
        User u = findById(id);
        u.setName(newUser.getName());
        u.setEmail(newUser.getEmail());
        return repo.save(u);
    }

    @CacheEvict(value = "users", key = "#id")
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
