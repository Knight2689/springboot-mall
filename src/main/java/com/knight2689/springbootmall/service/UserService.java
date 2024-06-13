package com.knight2689.springbootmall.service;

import com.knight2689.springbootmall.dto.UserLoginRequest;
import com.knight2689.springbootmall.dto.UserRegisterRequest;
import com.knight2689.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
