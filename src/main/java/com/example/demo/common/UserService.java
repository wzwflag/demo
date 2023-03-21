package com.example.demo.common;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

     int add(User user);

     int delete(Long userId);

     int update(User user);

     User getById(Long userId);

     List<User> find();

}
