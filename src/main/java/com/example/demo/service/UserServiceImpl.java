package com.example.demo.service;

import com.example.demo.common.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RedisTemplate redisTemplate;

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
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        SqlRowSet rst = jdbcTemplate.queryForRowSet("select * from user where id = ?", userId);
        User user = new User();
        while (rst.next()){
            user.setId(userId);
            user.setName(rst.getString("username"));
            user.setPsw(rst.getString("password"));
            user.setPhoneNumber(rst.getLong("phone"));
        }
        redisTemplate.opsForValue().set("user", userId);
        System.out.println(redisTemplate.opsForValue().get("user"));
//        redisTemplate.delete("user");
        return user;
    }

    @Override
    public List<User> find() {
        return null;
    }
}
