package com.knight2689.springbootmall.dao;

import com.knight2689.springbootmall.dto.UserRegisterRequest;
import com.knight2689.springbootmall.model.User;

public interface UserDao {


    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
