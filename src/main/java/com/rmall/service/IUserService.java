package com.rmall.service;

import com.rmall.commom.ServerResponse;
import com.rmall.pojo.User;

/**
 * Created by ylf on 2017/11/7.
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);
}
