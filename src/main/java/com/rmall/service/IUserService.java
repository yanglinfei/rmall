package com.rmall.service;

import com.rmall.commom.ServerResponse;
import com.rmall.pojo.User;

/**
 * Created by ylf on 2017/11/7.
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse<String> selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetResetPassword(String username, String newPassword, String forgetToken);

    ServerResponse<String> resetPassword(String username, String oldPassword, String newPassword);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);
}
