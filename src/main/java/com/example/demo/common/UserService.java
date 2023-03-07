package com.example.demo.common;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

     int add(User user);

     int delete(Long userId);

     int update(User user);

     int searchById(Long userId);

     List<User> find();

}
