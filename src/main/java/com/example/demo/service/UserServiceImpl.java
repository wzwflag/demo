package com.example.demo.service;

import com.example.demo.common.UserService;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public int delete(Long userId) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public User getById(Long userId) {
        return null;
    }

    @Override
    public List<User> find() {
        return null;
    }
}
