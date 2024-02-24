package com.javatechnophile.jwt.api.service;

import com.javatechnophile.jwt.api.entity.User;
import com.javatechnophile.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
